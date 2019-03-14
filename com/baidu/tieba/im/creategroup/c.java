package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes5.dex */
public class c {
    public static String gfg = "pic_found_address";
    public static String gfh = "pic_found_recommend";
    public static String gfi = "pic_didian";
    public static String gfj = "pic_found_name";
    public static String gfk = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.apQ().pB(str + "_1.png") : com.baidu.tbadk.util.c.apQ().pB(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.jB().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
