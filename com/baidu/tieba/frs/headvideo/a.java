package com.baidu.tieba.frs.headvideo;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a {
    private static int bXM = 1;

    public static int acj() {
        if (bXM == 1) {
            int i = com.baidu.tbadk.core.sharedPref.b.uo().getInt(acl(), 0);
            if (i >= 2) {
                return 0;
            }
            return (i == 0 || i == 1) ? 1 : 0;
        }
        return 0;
    }

    public static void ack() {
        String acl = acl();
        int i = com.baidu.tbadk.core.sharedPref.b.uo().getInt(acl, 0) + 1;
        com.baidu.tbadk.core.sharedPref.b.uo().putInt(acl, i);
        if (i >= 2) {
            bXM = 0;
        } else if (i == 0 || i == 1) {
            bXM = 1;
        } else {
            bXM = 0;
        }
    }

    private static String acl() {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (!StringUtils.isNull(currentAccount)) {
            return "frs_head_video_guide_by_count";
        }
        return String.valueOf(currentAccount) + "frs_head_video_guide_by_count";
    }
}
