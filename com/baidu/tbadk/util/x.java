package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class x {
    public static boolean isEMUI() {
        return G("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean G(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a bwM = a.bwM();
            for (String str : strArr) {
                if (bwM.getProperty(str) != null) {
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
        private static a eYs;
        private final Properties eYt = new Properties();

        private a() throws IOException {
            this.eYt.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a bwM() throws IOException {
            if (eYs == null) {
                synchronized (a.class) {
                    if (eYs == null) {
                        eYs = new a();
                    }
                }
            }
            return eYs;
        }

        public String getProperty(String str) {
            return this.eYt.getProperty(str);
        }
    }
}
