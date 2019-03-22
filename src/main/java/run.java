import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import sun.nio.cs.Surrogate;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * File：run.java <br>
 * Title: <br>
 * Description: <br>
 * Company: wondersgroup.com <br>
 * Datetime: 2019/3/22 16:41
 *
 * @author zwq
 * @version 1.0
 */
public class run {
    public static void main(String[] args) {
        //以下两种方法都可以
        generator();
        //generator1();
    }

    public static void generator() {
        List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        //File configFile = new File(run.class.getClassLoader().getResource("config.xml").getFile());
        File configFile = new File( run.class.getClassLoader().getResource("generatorConfig.xml").getFile());
        //File configFile = new File("config.xml");
        //File configFile = new File("generatorConfig.xml");
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config;
        try {
            config = cp.parseConfiguration(configFile);
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("ok");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generator1() {
        try {
            List<String> warnings = new ArrayList<String>();
            boolean overwrite = true;
            ConfigurationParser cp = new ConfigurationParser(warnings);
            Configuration config = cp.parseConfiguration(Surrogate.Generator.class.getResourceAsStream("/generatorConfig.xml"));
            //Configuration config = cp.parseConfiguration(Surrogate.Generator.class.getResourceAsStream("/config.xml"));
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
            myBatisGenerator.generate(null);
            System.out.println("============Success============");
        } catch (SQLException | IOException | InterruptedException | InvalidConfigurationException | XMLParserException var9) {
            var9.printStackTrace();
        }
    }
}
