package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int cbe = 1;

    public static int aec() {
        if (cbe == 1 || cbe == 2) {
            int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt(aee(), 0);
            if (i >= 3) {
                return 0;
            }
            if (i == 0 || i == 1) {
                return 1;
            }
            return i == 2 ? 2 : 0;
        }
        return 0;
    }

    public static void aed() {
        String aee = aee();
        int i = com.baidu.tbadk.core.sharedPref.b.tS().getInt(aee, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.tS().putInt(aee, i);
        if (i >= 3) {
            cbe = 0;
        } else if (i == 0 || i == 1) {
            cbe = 1;
        } else if (i == 2) {
            cbe = 2;
        } else {
            cbe = 0;
        }
    }

    private static String aee() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
