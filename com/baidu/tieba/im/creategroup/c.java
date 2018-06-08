package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String egB = "pic_found_address";
    public static String egC = "pic_found_recommend";
    public static String egD = "pic_didian";
    public static String egE = "pic_found_name";
    public static String egF = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.b.KQ().hs(str + "_1.png") : com.baidu.tbadk.util.b.KQ().hs(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.ig().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
