package com.baidu.tbadk.util;

import android.util.DisplayMetrics;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class b {
    private static b aqB;

    public static b Di() {
        if (aqB == null) {
            aqB = new b();
        }
        return aqB;
    }

    public String eI(String str) {
        String str2;
        new DisplayMetrics();
        if (BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
            str2 = "hdpi";
        } else {
            str2 = "xhdpi";
        }
        return "http://tb1.bdstatic.com/tb/client/img/" + str2 + "/" + str;
    }
}
