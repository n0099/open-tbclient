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
            a awu = a.awu();
            for (String str : strArr) {
                if (awu.rl(str) != null) {
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
        private static a cDl;
        private final Properties cDm = new Properties();

        private a() throws IOException {
            this.cDm.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a awu() throws IOException {
            if (cDl == null) {
                synchronized (a.class) {
                    if (cDl == null) {
                        cDl = new a();
                    }
                }
            }
            return cDl;
        }

        public String rl(String str) {
            return this.cDm.getProperty(str);
        }
    }
}
