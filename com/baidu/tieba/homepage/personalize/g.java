package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> kbd = new HashMap<>();

    public static void Lq(String str) {
        if (!TextUtils.isEmpty(str)) {
            kbd.put(str, 0);
        }
    }

    public static int cPs() {
        return kbd.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            kbd.clear();
        }
    }

    public static void cPt() {
        kbd.clear();
    }
}
