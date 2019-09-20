package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class t {
    public static boolean isEMUI() {
        return r("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean r(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a awG = a.awG();
            for (String str : strArr) {
                if (awG.rw(str) != null) {
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
        private static a cEc;
        private final Properties cEd = new Properties();

        private a() throws IOException {
            this.cEd.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a awG() throws IOException {
            if (cEc == null) {
                synchronized (a.class) {
                    if (cEc == null) {
                        cEc = new a();
                    }
                }
            }
            return cEc;
        }

        public String rw(String str) {
            return this.cEd.getProperty(str);
        }
    }
}
