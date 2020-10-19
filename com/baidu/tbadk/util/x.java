package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class x {
    public static boolean isEMUI() {
        return H("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean H(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a bzw = a.bzw();
            for (String str : strArr) {
                if (bzw.getProperty(str) != null) {
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
        private static a fkE;
        private final Properties fkF = new Properties();

        private a() throws IOException {
            this.fkF.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a bzw() throws IOException {
            if (fkE == null) {
                synchronized (a.class) {
                    if (fkE == null) {
                        fkE = new a();
                    }
                }
            }
            return fkE;
        }

        public String getProperty(String str) {
            return this.fkF.getProperty(str);
        }
    }
}
