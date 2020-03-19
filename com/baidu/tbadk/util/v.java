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
            a aSp = a.aSp();
            for (String str : strArr) {
                if (aSp.vX(str) != null) {
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
        private static a dHl;
        private final Properties dHm = new Properties();

        private a() throws IOException {
            this.dHm.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a aSp() throws IOException {
            if (dHl == null) {
                synchronized (a.class) {
                    if (dHl == null) {
                        dHl = new a();
                    }
                }
            }
            return dHl;
        }

        public String vX(String str) {
            return this.dHm.getProperty(str);
        }
    }
}
