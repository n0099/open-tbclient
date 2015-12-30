package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class x {
    public static void gH(String str) {
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && !readThreadHistory.mC(str)) {
            readThreadHistory.mB(str);
        }
    }

    public static boolean gI(String str) {
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        return readThreadHistory != null && readThreadHistory.mC(str);
    }

    public static String Im() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String In() {
        return "personalize_page";
    }
}
