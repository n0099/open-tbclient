package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String eLz = "pic_found_address";
    public static String eLA = "pic_found_recommend";
    public static String eLB = "pic_didian";
    public static String eLC = "pic_found_name";
    public static String eLD = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.PL().iy(str + "_1.png") : com.baidu.tbadk.util.c.PL().iy(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.jA().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
