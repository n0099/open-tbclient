package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes5.dex */
public class c {
    public static String gCu = "pic_found_address";
    public static String gCv = "pic_found_recommend";
    public static String gCw = "pic_didian";
    public static String gCx = "pic_found_name";
    public static String gCy = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.awa().rb(str + "_1.png") : com.baidu.tbadk.util.c.awa().rb(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.iE().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
