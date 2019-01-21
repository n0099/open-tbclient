package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String ePd = "pic_found_address";
    public static String ePe = "pic_found_recommend";
    public static String ePf = "pic_didian";
    public static String ePg = "pic_found_name";
    public static String ePh = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.Qf().iN(str + "_1.png") : com.baidu.tbadk.util.c.Qf().iN(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.jA().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
