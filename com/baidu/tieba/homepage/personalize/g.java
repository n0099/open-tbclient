package com.baidu.tieba.homepage.personalize;

import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class g {
    private static boolean enabled = true;
    private static HashMap<String, Integer> kjn = new HashMap<>();

    public static void Mf(String str) {
        if (!TextUtils.isEmpty(str)) {
            kjn.put(str, 0);
        }
    }

    public static int cRr() {
        return kjn.size();
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean z) {
        enabled = z;
        if (!enabled) {
            kjn.clear();
        }
    }

    public static void cRs() {
        kjn.clear();
    }
}
