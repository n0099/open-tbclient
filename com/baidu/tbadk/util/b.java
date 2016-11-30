package com.baidu.tbadk.util;

import android.util.DisplayMetrics;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class b {
    private static b aEV;

    public static b GT() {
        if (aEV == null) {
            aEV = new b();
        }
        return aEV;
    }

    public String gq(String str) {
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
