package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class r {
    public static boolean isEMUI() {
        return q("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean q(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a OK = a.OK();
            for (String str : strArr) {
                if (OK.getProperty(str) != null) {
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
        private static a beq;
        private final Properties ber = new Properties();

        private a() throws IOException {
            this.ber.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a OK() throws IOException {
            if (beq == null) {
                synchronized (a.class) {
                    if (beq == null) {
                        beq = new a();
                    }
                }
            }
            return beq;
        }

        public String getProperty(String str) {
            return this.ber.getProperty(str);
        }
    }
}
