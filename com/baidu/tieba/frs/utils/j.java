package com.baidu.tieba.frs.utils;

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
import com.baidu.tieba.r;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class j {
    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.n nVar, String str) {
        if (tbPageContext != null && nVar != null && nVar.aJY() != null) {
            if (nVar.aJY().getName() == null) {
                tbPageContext.showToast(tbPageContext.getString(r.l.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = nVar.aJY().getName();
            String str2 = TbConfig.HTTPS_FRS_PREFIX + URLEncoder.encode(name);
            Uri parse = nVar.aJY().getImage_url() == null ? null : Uri.parse(nVar.aJY().getImage_url());
            String slogan = nVar.aJY().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + tbPageContext.getString(r.l.forum);
            fVar.content = slogan;
            fVar.linkUrl = str2;
            fVar.amt = true;
            fVar.extData = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(r.l.forum_friend, r.g.icon_unite_share_baf, new k(tbPageContext, str));
            shareDialogConfig.setCopyLinkListener(new l(fVar, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, Intent intent) {
        a(frsActivity, nVar, f(nVar), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private static ShareFromFrsMsgData f(com.baidu.tieba.tbadkCore.n nVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(nVar.aJY().getImage_url());
        shareFromFrsMsgData.setName(nVar.aJY().getName());
        shareFromFrsMsgData.setMemberNum(nVar.aJY().getMember_num());
        shareFromFrsMsgData.setPostNum(nVar.aJY().getPost_num());
        shareFromFrsMsgData.setContent(nVar.aJY().getSlogan());
        return shareFromFrsMsgData;
    }

    private static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (nVar != null && nVar.aJY() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar.setData(shareFromFrsMsgData);
            aVar.cc(1);
            aVar.x(oVar);
            aVar.a(r.l.share, new m(frsActivity, oVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(r.l.alert_no_button, new n(frsActivity, oVar));
            aVar.av(true);
            aVar.b(frsActivity.getPageContext()).sV();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                oVar.F(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.n nVar, int i, String str, long j) {
        if (nVar != null && nVar.aJY() != null) {
            ShareFromFrsMsgData f = f(nVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar.setData(f);
            aVar.cc(1);
            aVar.x(oVar);
            aVar.a(r.l.share, new o(frsActivity, oVar, i, str, j, f));
            aVar.b(r.l.alert_no_button, new p(frsActivity, oVar));
            aVar.av(true);
            aVar.b(frsActivity.getPageContext()).sV();
            if (!com.baidu.adp.lib.util.j.isEmpty(f.getImageUrl())) {
                oVar.F(f.getImageUrl(), false);
            }
        }
    }
}
