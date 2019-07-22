package com.baidu.tieba.frs.gametab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class c {
    public static boolean a(TbPageContext<?> tbPageContext, FrsViewData frsViewData) {
        String fixedText;
        if (tbPageContext == null || frsViewData == null) {
            return false;
        }
        if (bd.cF(tbPageContext.getPageActivity())) {
            AntiData anti = frsViewData.getAnti();
            if (anti != null) {
                if (a(tbPageContext, anti.getBlock_stat(), anti.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (anti.getIfpost() == 0 && !StringUtils.isNull(anti.getForbid_info())) {
                    String forbid_info = anti.getForbid_info();
                    if (aq.oc(forbid_info) > 14) {
                        forbid_info = aq.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast c = BdToast.c(tbPageContext.getPageActivity(), forbid_info, R.drawable.icon_toast_game_error);
                    c.am(1.25f);
                    c.agQ();
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    public static boolean a(final TbPageContext<?> tbPageContext, int i, final BlockPopInfoData blockPopInfoData) {
        if (blockPopInfoData == null || blockPopInfoData.can_post.intValue() == 1 || !TbadkCoreApplication.isLogin()) {
            return false;
        }
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? tbPageContext.getResources().getString(R.string.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast c = BdToast.c(tbPageContext.getPageActivity(), string, R.drawable.icon_toast_game_error);
            c.am(1.25f);
            c.agQ();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.mO(aq.getFixedText(string, 50, true));
        aVar.b(aq.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? tbPageContext.getResources().getString(R.string.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(aq.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.c.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    bb.ajC().c(TbPageContext.this, new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(tbPageContext).agI();
        return true;
    }
}
