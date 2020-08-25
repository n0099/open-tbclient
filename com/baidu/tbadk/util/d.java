package com.baidu.tbadk.util;

import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes2.dex */
public class d {
    private static d eUP;

    public static d bvi() {
        if (eUP == null) {
            eUP = new d();
        }
        return eUP;
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
