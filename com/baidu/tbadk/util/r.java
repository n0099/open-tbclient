package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class r {
    public static boolean isEMUI() {
        return s("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean s(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a OT = a.OT();
            for (String str : strArr) {
                if (OT.getProperty(str) != null) {
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
        private static a bff;
        private final Properties bfg = new Properties();

        private a() throws IOException {
            this.bfg.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a OT() throws IOException {
            if (bff == null) {
                synchronized (a.class) {
                    if (bff == null) {
                        bff = new a();
                    }
                }
            }
            return bff;
        }

        public String getProperty(String str) {
            return this.bfg.getProperty(str);
        }
    }
}
