package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int ceD = 1;

    public static int afL() {
        if (ceD == 1) {
            int i = com.baidu.tbadk.core.sharedPref.b.um().getInt(afN(), 0);
            if (i >= 2) {
                return 0;
            }
            return (i == 0 || i == 1) ? 1 : 0;
        }
        return 0;
    }

    public static void afM() {
        String afN = afN();
        int i = com.baidu.tbadk.core.sharedPref.b.um().getInt(afN, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.um().putInt(afN, i);
        if (i >= 2) {
            ceD = 0;
        } else if (i == 0 || i == 1) {
            ceD = 1;
        } else {
            ceD = 0;
        }
    }

    private static String afN() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
