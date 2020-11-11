package com.baidu.tbadk.util;

import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class d {
    private static d fym;

    public static d bDp() {
        if (fym == null) {
            fym = new d();
        }
        return fym;
    }

    public String getUrlByNet(String str) {
        String str2;
        if (BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
            str2 = "hdpi";
        } else {
            str2 = "xhdpi";
        }
        return "http://tb1.bdstatic.com/tb/client/img/" + str2 + "/" + str;
    }
}
