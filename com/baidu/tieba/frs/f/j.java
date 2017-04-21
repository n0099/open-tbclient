package com.baidu.tieba.frs.f;

import android.content.Intent;
import android.net.Uri;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.w;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class j {
    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, String str) {
        if (tbPageContext != null && nVar != null && nVar.aKx() != null) {
            if (nVar.aKx().getName() == null) {
                tbPageContext.showToast(tbPageContext.getString(w.l.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = nVar.aKx().getName();
            String str2 = TbConfig.HTTPS_FRS_PREFIX + URLEncoder.encode(name);
            Uri parse = nVar.aKx().getImage_url() == null ? null : Uri.parse(nVar.aKx().getImage_url());
            String slogan = nVar.aKx().getSlogan();
            com.baidu.tbadk.coreExtra.share.h hVar = new com.baidu.tbadk.coreExtra.share.h();
            hVar.title = String.valueOf(name) + tbPageContext.getString(w.l.forum);
            hVar.content = slogan;
            hVar.linkUrl = str2;
            hVar.asf = true;
            hVar.extData = str;
            if (parse != null) {
                hVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), hVar, true);
            shareDialogConfig.addOutsideTextView(w.l.forum_friend, w.g.icon_unite_share_baf, new k(tbPageContext, str));
            shareDialogConfig.setCopyLinkListener(new l(str2, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, Intent intent) {
        a(frsActivity, nVar, f(nVar), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private static ShareFromFrsMsgData f(com.baidu.tieba.tbadkCore.n nVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(nVar.aKx().getImage_url());
        shareFromFrsMsgData.setName(nVar.aKx().getName());
        shareFromFrsMsgData.setMemberNum(nVar.aKx().getMember_num());
        shareFromFrsMsgData.setPostNum(nVar.aKx().getPost_num());
        shareFromFrsMsgData.setContent(nVar.aKx().getSlogan());
        return shareFromFrsMsgData;
    }

    private static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (nVar != null && nVar.aKx() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar.setData(shareFromFrsMsgData);
            aVar.cb(1);
            aVar.v(oVar);
            aVar.a(w.l.share, new m(frsActivity, oVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(w.l.alert_no_button, new n(frsActivity, oVar));
            aVar.aw(true);
            aVar.b(frsActivity.getPageContext()).tQ();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                oVar.G(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, int i, String str, long j) {
        if (nVar != null && nVar.aKx() != null) {
            ShareFromFrsMsgData f = f(nVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar.setData(f);
            aVar.cb(1);
            aVar.v(oVar);
            aVar.a(w.l.share, new o(frsActivity, oVar, i, str, j, f));
            aVar.b(w.l.alert_no_button, new p(frsActivity, oVar));
            aVar.aw(true);
            aVar.b(frsActivity.getPageContext()).tQ();
            if (!com.baidu.adp.lib.util.j.isEmpty(f.getImageUrl())) {
                oVar.G(f.getImageUrl(), false);
            }
        }
    }
}
