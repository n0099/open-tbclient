package com.baidu.tbadk.coreExtra.share;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class e {
    private static int bbf() {
        if (aq.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return 3;
        }
        return com.baidu.tbadk.core.sharedPref.b.aTX().getInt("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
    }

    public static int bbg() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().aYg()) {
            return -1;
        }
        switch (bbf()) {
            case 2:
                return R.drawable.icon_mask_share_circle40_svg;
            case 3:
            case 5:
            case 7:
            default:
                return R.drawable.icon_mask_share_wechat40_svg;
            case 4:
                return R.drawable.icon_mask_share_qqzone40_svg;
            case 6:
                return R.drawable.icon_mask_share_weibo40_svg;
            case 8:
                return R.drawable.icon_mask_share_qq40_svg;
        }
    }

    public static void mK(int i) {
        if (i > 0 && !aq.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.sharedPref.b.aTX().putInt("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i);
        }
    }
}
