package com.baidu.tbadk.util;

import android.util.DisplayMetrics;
import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class b {
    private static b azT;

    public static b Fo() {
        if (azT == null) {
            azT = new b();
        }
        return azT;
    }

    public String gf(String str) {
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
