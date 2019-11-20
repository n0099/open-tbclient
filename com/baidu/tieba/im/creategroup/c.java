package com.baidu.tieba.im.creategroup;

import android.app.Activity;
/* loaded from: classes5.dex */
public class c {
    public static String gCm = "pic_found_address";
    public static String gCn = "pic_found_recommend";
    public static String gCo = "pic_didian";
    public static String gCp = "pic_found_name";
    public static String gCq = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.axr().getUrlByNet(str + "_1.png") : com.baidu.tbadk.util.c.axr().getUrlByNet(str + ".png");
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.f.c.fT().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
