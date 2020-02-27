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
            a aSi = a.aSi();
            for (String str : strArr) {
                if (aSi.vV(str) != null) {
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
        private static a dGH;
        private final Properties dGI = new Properties();

        private a() throws IOException {
            this.dGI.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aSi() throws IOException {
            if (dGH == null) {
                synchronized (a.class) {
                    if (dGH == null) {
                        dGH = new a();
                    }
                }
            }
            return dGH;
        }

        public String vV(String str) {
            return this.dGI.getProperty(str);
        }
    }
}
