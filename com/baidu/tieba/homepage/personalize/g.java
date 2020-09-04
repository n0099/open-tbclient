package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes16.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> iNX = new HashMap<>();

    public static void JL(String str) {
        if (!TextUtils.isEmpty(str)) {
            iNX.put(str, 0);
        }
    }

    public static int cyi() {
        return iNX.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            iNX.clear();
        }
    }

    public static void cyj() {
        iNX.clear();
    }
}
