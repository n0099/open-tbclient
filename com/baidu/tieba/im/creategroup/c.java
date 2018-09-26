package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String evC = "pic_found_address";
    public static String evD = "pic_found_recommend";
    public static String evE = "pic_didian";
    public static String evF = "pic_found_name";
    public static String evG = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.My().hQ(str + "_1.png") : com.baidu.tbadk.util.c.My().hQ(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.jn().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
