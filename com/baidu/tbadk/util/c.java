package com.baidu.tbadk.util;

import com.baidu.adp.base.BdBaseApplication;
/* loaded from: classes.dex */
public class c {
    private static c bdX;

    public static c Ow() {
        if (bdX == null) {
            bdX = new c();
        }
        return bdX;
    }

    /* renamed from: if  reason: not valid java name */
    public String m18if(String str) {
        String str2;
        if (BdBaseApplication.getInst().getContext().getResources().getDisplayMetrics().densityDpi <= 240) {
            str2 = "hdpi";
        } else {
            str2 = "xhdpi";
        }
        return "http://tb1.bdstatic.com/tb/client/img/" + str2 + "/" + str;
    }
}
