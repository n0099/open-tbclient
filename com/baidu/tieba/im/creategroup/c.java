package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes5.dex */
public class c {
    public static String geU = "pic_found_address";
    public static String geV = "pic_found_recommend";
    public static String geW = "pic_didian";
    public static String geX = "pic_found_name";
    public static String geY = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.apN().pC(str + "_1.png") : com.baidu.tbadk.util.c.apN().pC(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.jB().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
