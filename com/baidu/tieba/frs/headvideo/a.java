package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int bKm = 1;

    public static int aah() {
        if (bKm == 1) {
            int i = com.baidu.tbadk.core.sharedPref.b.tW().getInt(aaj(), 0);
            if (i >= 2) {
                return 0;
            }
            return (i == 0 || i == 1) ? 1 : 0;
        }
        return 0;
    }

    public static void aai() {
        String aaj = aaj();
        int i = com.baidu.tbadk.core.sharedPref.b.tW().getInt(aaj, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.tW().putInt(aaj, i);
        if (i >= 2) {
            bKm = 0;
        } else if (i == 0 || i == 1) {
            bKm = 1;
        } else {
            bKm = 0;
        }
    }

    private static String aaj() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
