package com.baidu.tbadk.util;

import android.os.Environment;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
/* loaded from: classes.dex */
public final class w {
    public static boolean isEMUI() {
        return F("ro.build.version.emui", "ro.build.hw_emui_api_level");
    }

    private static boolean F(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return false;
        }
        try {
            a biW = a.biW();
            for (String str : strArr) {
                if (biW.getProperty(str) != null) {
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
        private static a eEw;
        private final Properties eEx = new Properties();

        private a() throws IOException {
            this.eEx.load(new FileInputStream(new File(Environment.getRootDirectory(), "build.prop")));
        }

        public static a biW() throws IOException {
            if (eEw == null) {
                synchronized (a.class) {
                    if (eEw == null) {
                        eEw = new a();
                    }
                }
            }
            return eEw;
        }

        public String getProperty(String str) {
            return this.eEx.getProperty(str);
        }
    }
}
