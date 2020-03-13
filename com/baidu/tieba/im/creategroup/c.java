package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes10.dex */
public class c {
    public static String hwh = "pic_found_address";
    public static String hwi = "pic_found_recommend";
    public static String hwj = "pic_didian";
    public static String hwk = "pic_found_name";
    public static String hwl = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.aRR().getUrlByNet(str + "_1.png") : com.baidu.tbadk.util.c.aRR().getUrlByNet(str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX);
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.e.c.gr().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
