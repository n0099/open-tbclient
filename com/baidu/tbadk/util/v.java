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
            a aSl = a.aSl();
            for (String str : strArr) {
                if (aSl.vW(str) != null) {
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
        private static a dGV;
        private final Properties dGW = new Properties();

        private a() throws IOException {
            this.dGW.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aSl() throws IOException {
            if (dGV == null) {
                synchronized (a.class) {
                    if (dGV == null) {
                        dGV = new a();
                    }
                }
            }
            return dGV;
        }

        public String vW(String str) {
            return this.dGW.getProperty(str);
        }
    }
}
