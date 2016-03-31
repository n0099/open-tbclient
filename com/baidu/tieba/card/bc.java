package com.baidu.tieba.card;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class bc {
    public static void ha(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        if (!StringUtils.isNull(str) && (readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory()) != null && !readThreadHistory.oh(str)) {
            readThreadHistory.og(str);
        }
    }

    public static boolean hb(String str) {
        com.baidu.tieba.tbadkCore.util.s readThreadHistory;
        return (StringUtils.isNull(str) || (readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory()) == null || !readThreadHistory.oh(str)) ? false : true;
    }

    public static String Lr() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String Ls() {
        return "personalize_page";
    }

    public static void a(TextView textView, String str, int i, int i2) {
        if (textView instanceof TextView) {
            if (hb(str)) {
                com.baidu.tbadk.core.util.at.j((View) textView, i2);
            } else {
                com.baidu.tbadk.core.util.at.j((View) textView, i);
            }
        }
    }
}
