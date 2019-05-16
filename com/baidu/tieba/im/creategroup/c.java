package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes5.dex */
public class c {
    public static String gwg = "pic_found_address";
    public static String gwh = "pic_found_recommend";
    public static String gwi = "pic_didian";
    public static String gwj = "pic_found_name";
    public static String gwk = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.auR().qL(str + "_1.png") : com.baidu.tbadk.util.c.auR().qL(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.iv().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
