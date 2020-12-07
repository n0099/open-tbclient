package com.baidu.tbadk.coreExtra.share;

import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class f {
    private static int bAo() {
        if (au.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            return 3;
        }
        return com.baidu.tbadk.core.sharedPref.b.bsO().getInt("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), 3);
    }

    public static int bAp() {
        if (TbSingleton.getInstance().getSharePanelConfData() == null || !TbSingleton.getInstance().getSharePanelConfData().bxG()) {
            return -1;
        }
        int bAo = bAo();
        int i = R.drawable.icon_mask_share_wechat40_svg;
        switch (bAo) {
            case 2:
                return R.drawable.icon_mask_share_circle40_svg;
            case 3:
                return R.drawable.icon_mask_share_wechat40_svg;
            case 4:
                return R.drawable.icon_mask_share_qqzone40_svg;
            case 5:
            case 7:
            default:
                return R.drawable.icon_mask_share_wechat40_svg;
            case 6:
                return R.drawable.icon_mask_share_weibo40_svg;
            case 8:
                return R.drawable.icon_mask_share_qq40_svg;
        }
    }

    public static void rO(int i) {
        if (i > 0 && !au.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putInt("key_shared_record_prefix_" + TbadkCoreApplication.getCurrentAccount(), i);
        }
    }
}
