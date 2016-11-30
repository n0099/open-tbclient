package com.baidu.tieba.frs.utils;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.r;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class j {
    public static int from = 0;

    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.p pVar, String str) {
        if (tbPageContext != null && pVar != null && pVar.aOk() != null) {
            from = 1;
            if (pVar.aOk().getName() == null) {
                tbPageContext.showToast(tbPageContext.getString(r.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = pVar.aOk().getName();
            String str2 = "http://tieba.baidu.com/f?kw=" + URLEncoder.encode(name);
            Uri parse = pVar.aOk().getImage_url() == null ? null : Uri.parse(pVar.aOk().getImage_url());
            String slogan = pVar.aOk().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + tbPageContext.getString(r.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str2;
            fVar.anK = true;
            fVar.extData = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(r.j.share_tieba_qunzu, r.f.icon_unite_share_qunzu, new k(tbPageContext, str));
            shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new l(tbPageContext, str));
            shareDialogConfig.setCopyLinkListener(new m(fVar, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, Intent intent) {
        a(frsActivity, pVar, g(pVar), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private static ShareFromFrsMsgData g(com.baidu.tieba.tbadkCore.p pVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(pVar.aOk().getImage_url());
        shareFromFrsMsgData.setName(pVar.aOk().getName());
        shareFromFrsMsgData.setMemberNum(pVar.aOk().getMember_num());
        shareFromFrsMsgData.setPostNum(pVar.aOk().getPost_num());
        shareFromFrsMsgData.setContent(pVar.aOk().getSlogan());
        return shareFromFrsMsgData;
    }

    private static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (pVar != null && pVar.aOk() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar.setData(shareFromFrsMsgData);
            aVar.cc(1);
            aVar.z(oVar);
            aVar.a(r.j.share, new n(frsActivity, oVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(r.j.alert_no_button, new o(frsActivity, oVar));
            aVar.au(true);
            aVar.b(frsActivity.getPageContext()).tq();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                oVar.F(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, int i, String str, long j) {
        if (pVar != null && pVar.aOk() != null) {
            ShareFromFrsMsgData g = g(pVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar.setData(g);
            aVar.cc(1);
            aVar.z(oVar);
            aVar.a(r.j.share, new p(frsActivity, oVar, i, str, j, g));
            aVar.b(r.j.alert_no_button, new q(frsActivity, oVar));
            aVar.au(true);
            aVar.b(frsActivity.getPageContext()).tq();
            if (!com.baidu.adp.lib.util.j.isEmpty(g.getImageUrl())) {
                oVar.F(g.getImageUrl(), false);
            }
        }
    }
}
