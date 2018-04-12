package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes3.dex */
public class c {
    public static String dUk = "pic_found_address";
    public static String dUl = "pic_found_recommend";
    public static String dUm = "pic_didian";
    public static String dUn = "pic_found_name";
    public static String dUo = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.b.Hy().gX(str + "_1.png") : com.baidu.tbadk.util.b.Hy().gX(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.fp().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
