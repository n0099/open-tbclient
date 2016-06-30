package com.baidu.tieba.frs;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class cp {
    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.p pVar, String str) {
        String name;
        if (tbPageContext != null && pVar != null && pVar.aDN() != null) {
            if (pVar.aDN().getName() == null) {
                tbPageContext.showToast(tbPageContext.getString(u.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str2 = "http://tieba.baidu.com/f?kw=" + pVar.aDN().getName();
            Uri parse = pVar.aDN().getImage_url() == null ? null : Uri.parse(pVar.aDN().getImage_url());
            String slogan = pVar.aDN().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + tbPageContext.getString(u.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str2;
            fVar.ajp = true;
            fVar.extData = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(u.j.share_tieba_qunzu, u.f.icon_unite_share_qunzu, new cq(tbPageContext, str));
            shareDialogConfig.addOutsideTextView(u.j.forum_friend, u.f.icon_unite_share_baf, new cr(tbPageContext, str));
            shareDialogConfig.setCopyLinkListener(new cs(fVar, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, Intent intent) {
        a(frsActivity, pVar, b(pVar), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private static ShareFromFrsMsgData b(com.baidu.tieba.tbadkCore.p pVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(pVar.aDN().getImage_url());
        shareFromFrsMsgData.setName(pVar.aDN().getName());
        shareFromFrsMsgData.setMemberNum(pVar.aDN().getMember_num());
        shareFromFrsMsgData.setPostNum(pVar.aDN().getPost_num());
        shareFromFrsMsgData.setContent(pVar.aDN().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (pVar != null && pVar.aDN() != null) {
            a aVar = new a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.n nVar = new com.baidu.tieba.frs.view.n(frsActivity.getPageContext().getPageActivity());
            nVar.setData(shareFromFrsMsgData);
            aVar.bO(1);
            aVar.y(nVar);
            aVar.a(u.j.share, new ct(frsActivity, nVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(u.j.alert_no_button, new cu(frsActivity, nVar));
            aVar.ao(true);
            aVar.b(frsActivity.getPageContext()).rT();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                nVar.A(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, int i, String str, long j) {
        if (pVar != null && pVar.aDN() != null) {
            ShareFromFrsMsgData b = b(pVar);
            a aVar = new a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.n nVar = new com.baidu.tieba.frs.view.n(frsActivity.getPageContext().getPageActivity());
            nVar.setData(b);
            aVar.bO(1);
            aVar.y(nVar);
            aVar.a(u.j.share, new cv(frsActivity, nVar, i, str, j, b));
            aVar.b(u.j.alert_no_button, new cw(frsActivity, nVar));
            aVar.ao(true);
            aVar.b(frsActivity.getPageContext()).rT();
            if (!com.baidu.adp.lib.util.j.isEmpty(b.getImageUrl())) {
                nVar.A(b.getImageUrl(), false);
            }
        }
    }
}
