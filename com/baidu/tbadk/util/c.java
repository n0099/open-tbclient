package com.baidu.tbadk.util;

import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class c {
    private static c biZ;

    public static c Qf() {
        if (biZ == null) {
            biZ = new c();
        }
        return biZ;
    }

    public String iN(String str) {
        String str2;
        if (BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
            str2 = "hdpi";
        } else {
            str2 = "xhdpi";
        }
        return "http://tb1.bdstatic.com/tb/client/img/" + str2 + "/" + str;
    }
}
