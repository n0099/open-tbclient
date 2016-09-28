package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int cbg = 1;

    public static int aer() {
        if (cbg == 1 || cbg == 2) {
            int i = com.baidu.tbadk.core.sharedPref.b.uh().getInt(aet(), 0);
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

    public static void aes() {
        String aet = aet();
        int i = com.baidu.tbadk.core.sharedPref.b.uh().getInt(aet, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.uh().putInt(aet, i);
        if (i >= 3) {
            cbg = 0;
        } else if (i == 0 || i == 1) {
            cbg = 1;
        } else if (i == 2) {
            cbg = 2;
        } else {
            cbg = 0;
        }
    }

    private static String aet() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
