package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class u {
    public static boolean isEMUI() {
        return r("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean r(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a aws = a.aws();
            for (String str : strArr) {
                if (aws.rl(str) != null) {
                    return true;
                }
            }
            return false;
        } catch (IOException e) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private static a cDe;
        private final Properties cDf = new Properties();

        private a() throws IOException {
            this.cDf.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aws() throws IOException {
            if (cDe == null) {
                synchronized (a.class) {
                    if (cDe == null) {
                        cDe = new a();
                    }
                }
            }
            return cDe;
        }

        public String rl(String str) {
            return this.cDf.getProperty(str);
        }
    }
}
