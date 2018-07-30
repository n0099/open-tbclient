package com.baidu.tieba.frs.gametab;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.BlockPopInfoData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class d {
    public static boolean a(TbPageContext<?> tbPageContext, l lVar) {
        String fixedText;
        if (tbPageContext == null || lVar == null) {
            return false;
        }
        if (ba.aV(tbPageContext.getPageActivity())) {
            AntiData uh = lVar.uh();
            if (uh != null) {
                if (a(tbPageContext, uh.getBlock_stat(), uh.mFrsForbidenDialogInfo)) {
                    return true;
                }
                if (uh.getIfpost() == 0 && !StringUtils.isNull(uh.getForbid_info())) {
                    String forbid_info = uh.getForbid_info();
                    if (ap.eK(forbid_info) > 14) {
                        forbid_info = ap.getFixedText(forbid_info, 7, false) + "\n" + forbid_info.substring(fixedText.length());
                    }
                    BdToast b = BdToast.b(tbPageContext.getPageActivity(), forbid_info, d.f.icon_toast_game_error);
                    b.Y(1.25f);
                    b.xn();
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
        String string = StringUtils.isNull(blockPopInfoData.block_info) ? tbPageContext.getResources().getString(d.j.frs_forbiden_dialog_msg) : blockPopInfoData.block_info;
        if (i != 1 && i != 2) {
            BdToast b = BdToast.b(tbPageContext.getPageActivity(), string, d.f.icon_toast_game_error);
            b.Y(1.25f);
            b.xn();
            return false;
        }
        com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.dB(ap.getFixedText(string, 50, true));
        aVar.b(ap.getFixedText(StringUtils.isNull(blockPopInfoData.ok_info) ? tbPageContext.getResources().getString(d.j.group_create_private_isee) : blockPopInfoData.ok_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.d.1
            @Override // com.baidu.tbadk.core.dialog.a.b
            public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                if (aVar2 != null) {
                    aVar2.dismiss();
                }
            }
        });
        if (!StringUtils.isNull(blockPopInfoData.ahead_info) && !StringUtils.isNull(blockPopInfoData.ahead_url)) {
            aVar.a(ap.getFixedText(blockPopInfoData.ahead_info, 4, true), new a.b() { // from class: com.baidu.tieba.frs.gametab.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    ay.zK().c(TbPageContext.this, new String[]{blockPopInfoData.ahead_url});
                    if (aVar2 != null) {
                        aVar2.dismiss();
                    }
                }
            });
        }
        aVar.b(tbPageContext).xf();
        return true;
    }
}
