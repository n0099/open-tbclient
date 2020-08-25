package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes16.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> iNR = new HashMap<>();

    public static void JK(String str) {
        if (!TextUtils.isEmpty(str)) {
            iNR.put(str, 0);
        }
    }

    public static int cyh() {
        return iNR.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            iNR.clear();
        }
    }

    public static void cyi() {
        iNR.clear();
    }
}
