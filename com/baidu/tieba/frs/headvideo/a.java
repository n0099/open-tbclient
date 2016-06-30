package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int bOl = 1;

    public static int YV() {
        if (bOl == 1 || bOl == 2) {
            int i = com.baidu.tbadk.core.sharedPref.b.sO().getInt(YX(), 0);
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

    public static void YW() {
        String YX = YX();
        int i = com.baidu.tbadk.core.sharedPref.b.sO().getInt(YX, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.sO().putInt(YX, i);
        if (i >= 3) {
            bOl = 0;
        } else if (i == 0 || i == 1) {
            bOl = 1;
        } else if (i == 2) {
            bOl = 2;
        } else {
            bOl = 0;
        }
    }

    private static String YX() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
