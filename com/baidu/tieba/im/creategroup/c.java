package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes5.dex */
public class c {
    public static String gDm = "pic_found_address";
    public static String gDn = "pic_found_recommend";
    public static String gDo = "pic_didian";
    public static String gDp = "pic_found_name";
    public static String gDq = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.awc().rb(str + "_1.png") : com.baidu.tbadk.util.c.awc().rb(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.iE().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
