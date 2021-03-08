package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> klD = new HashMap<>();

    public static void Mm(String str) {
        if (!TextUtils.isEmpty(str)) {
            klD.put(str, 0);
        }
    }

    public static int cRF() {
        return klD.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            klD.clear();
        }
    }

    public static void cRG() {
        klD.clear();
    }
}
