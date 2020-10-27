package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class x {
    public static boolean isEMUI() {
        return I("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean I(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a bBp = a.bBp();
            for (String str : strArr) {
                if (bBp.getProperty(str) != null) {
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
        private static a ftd;
        private final Properties fte = new Properties();

        private a() throws IOException {
            this.fte.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a bBp() throws IOException {
            if (ftd == null) {
                synchronized (a.class) {
                    if (ftd == null) {
                        ftd = new a();
                    }
                }
            }
            return ftd;
        }

        public String getProperty(String str) {
            return this.fte.getProperty(str);
        }
    }
}
