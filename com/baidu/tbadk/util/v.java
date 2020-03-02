package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class v {
    public static boolean isEMUI() {
        return D("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean D(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a aSk = a.aSk();
            for (String str : strArr) {
                if (aSk.vV(str) != null) {
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
        private static a dGI;
        private final Properties dGJ = new Properties();

        private a() throws IOException {
            this.dGJ.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aSk() throws IOException {
            if (dGI == null) {
                synchronized (a.class) {
                    if (dGI == null) {
                        dGI = new a();
                    }
                }
            }
            return dGI;
        }

        public String vV(String str) {
            return this.dGJ.getProperty(str);
        }
    }
}
