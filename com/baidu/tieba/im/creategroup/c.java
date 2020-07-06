package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes10.dex */
public class c {
    public static String iOb = "pic_found_address";
    public static String iOc = "pic_found_recommend";
    public static String iOd = "pic_didian";
    public static String iOe = "pic_found_name";
    public static String iOf = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.biB().getUrlByNet(str + "_1.png") : com.baidu.tbadk.util.c.biB().getUrlByNet(str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX);
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.e.c.ln().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
