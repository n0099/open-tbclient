package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes.dex */
public class c {
    public static String aSV = "pic_found_address";
    public static String aSW = "pic_found_recommend";
    public static String aSX = "pic_didian";
    public static String aSY = "pic_found_name";
    public static String aSZ = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.b.uY().dO(String.valueOf(str) + "_1.png") : com.baidu.tbadk.util.b.uY().dO(String.valueOf(str) + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.d.ef().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
