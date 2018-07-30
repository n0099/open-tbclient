package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String eon = "pic_found_address";
    public static String eoo = "pic_found_recommend";
    public static String eop = "pic_didian";
    public static String eoq = "pic_found_name";
    public static String eor = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.b.Ld().ht(str + "_1.png") : com.baidu.tbadk.util.b.Ld().ht(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.ih().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
