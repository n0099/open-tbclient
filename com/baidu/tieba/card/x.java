package com.baidu.tieba.card;

import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class x {
    public static void gI(String str) {
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        if (readThreadHistory != null && !readThreadHistory.mD(str)) {
            readThreadHistory.mC(str);
        }
    }

    public static boolean gJ(String str) {
        com.baidu.tieba.tbadkCore.util.q readThreadHistory = TbadkCoreApplication.m411getInst().getReadThreadHistory();
        return readThreadHistory != null && readThreadHistory.mD(str);
    }

    public static String Im() {
        return String.valueOf(System.currentTimeMillis() / 1000);
    }

    public static String In() {
        return "personalize_page";
    }
}
