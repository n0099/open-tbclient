package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class ae {
    public static void gO(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory()) != null && !readThreadHistory.mU(str)) {
            readThreadHistory.mT(str);
        }
    }

    public static boolean gP(String str) {
        com.baidu.tieba.tbadkCore.util.r readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory()) == null || !readThreadHistory.mU(str)) ? false : true;
    }

    public static String JU() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String JV() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (gP(str)) {
                com.baidu.tbadk.core.util.ar.j((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.ar.j((View) textView, i);
            }
        }
    }
}
