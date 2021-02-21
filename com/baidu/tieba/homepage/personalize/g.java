package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> kjB = new HashMap<>();

    public static void Mg(String str) {
        if (!TextUtils.isEmpty(str)) {
            kjB.put(str, 0);
        }
    }

    public static int cRy() {
        return kjB.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            kjB.clear();
        }
    }

    public static void cRz() {
        kjB.clear();
    }
}
