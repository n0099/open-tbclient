package com.baidu.tieba.im.creategroup;

import android.app.Activity;
import com.baidu.searchbox.ui.animview.praise.resource.ComboPraiseProvider;
/* loaded from: classes8.dex */
public class c {
    public static String htU = "pic_found_address";
    public static String htV = "pic_found_recommend";
    public static String htW = "pic_didian";
    public static String htX = "pic_found_name";
    public static String htY = "pic_benba";

    public static String a(Activity activity, String str, boolean z) {
        return z ? com.baidu.tbadk.util.c.aPx().getUrlByNet(str + "_1.png") : com.baidu.tbadk.util.c.aPx().getUrlByNet(str + ComboPraiseProvider.RES_NAME_PRAISE_NUMBER_SUFFIX);
    }

    public static void b(Activity activity, String str, boolean z) {
        com.baidu.adp.lib.e.c.gr().a(a(activity, str, z), 29, null, 0, 0, null, new Object[0]);
    }
}
