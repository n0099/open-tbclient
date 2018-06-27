package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String eku = "pic_found_address";
    public static String ekv = "pic_found_recommend";
    public static String ekw = "pic_didian";
    public static String ekx = "pic_found_name";
    public static String eky = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.b.Li().hw(str + "_1.png") : com.baidu.tbadk.util.b.Li().hw(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.ig().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
