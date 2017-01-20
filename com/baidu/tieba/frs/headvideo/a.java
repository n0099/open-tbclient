package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int bQE = 1;

    public static int abm() {
        if (bQE == 1) {
            int i = com.baidu.tbadk.core.sharedPref.b.tQ().getInt(abo(), 0);
            if (i >= 2) {
                return 0;
            }
            return (i == 0 || i == 1) ? 1 : 0;
        }
        return 0;
    }

    public static void abn() {
        String abo = abo();
        int i = com.baidu.tbadk.core.sharedPref.b.tQ().getInt(abo, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.tQ().putInt(abo, i);
        if (i >= 2) {
            bQE = 0;
        } else if (i == 0 || i == 1) {
            bQE = 1;
        } else {
            bQE = 0;
        }
    }

    private static String abo() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
