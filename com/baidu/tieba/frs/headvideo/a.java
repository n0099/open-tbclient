package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int bPW = 1;

    public static int Zq() {
        if (bPW == 1 || bPW == 2) {
            int i = com.baidu.tbadk.core.sharedPref.b.sN().getInt(Zs(), 0);
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

    public static void Zr() {
        String Zs = Zs();
        int i = com.baidu.tbadk.core.sharedPref.b.sN().getInt(Zs, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.sN().putInt(Zs, i);
        if (i >= 3) {
            bPW = 0;
        } else if (i == 0 || i == 1) {
            bPW = 1;
        } else if (i == 2) {
            bPW = 2;
        } else {
            bPW = 0;
        }
    }

    private static String Zs() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
