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
    public static int from = 0;

    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.o oVar, String str) {
        if (tbPageContext != null && oVar != null && oVar.aIk() != null) {
            from = 1;
            if (oVar.aIk().getName() == null) {
                tbPageContext.showToast(tbPageContext.getString(r.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String name = oVar.aIk().getName();
            String str2 = TbConfig.HTTPS_FRS_PREFIX + URLEncoder.encode(name);
            Uri parse = oVar.aIk().getImage_url() == null ? null : Uri.parse(oVar.aIk().getImage_url());
            String slogan = oVar.aIk().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + tbPageContext.getString(r.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str2;
            fVar.ann = true;
            fVar.extData = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(r.j.forum_friend, r.f.icon_unite_share_baf, new k(tbPageContext, str));
            shareDialogConfig.setCopyLinkListener(new l(fVar, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.o oVar, Intent intent) {
        a(frsActivity, oVar, g(oVar), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private static ShareFromFrsMsgData g(com.baidu.tieba.tbadkCore.o oVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(oVar.aIk().getImage_url());
        shareFromFrsMsgData.setName(oVar.aIk().getName());
        shareFromFrsMsgData.setMemberNum(oVar.aIk().getMember_num());
        shareFromFrsMsgData.setPostNum(oVar.aIk().getPost_num());
        shareFromFrsMsgData.setContent(oVar.aIk().getSlogan());
        return shareFromFrsMsgData;
    }

    private static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.o oVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (oVar != null && oVar.aIk() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar2 = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar2.setData(shareFromFrsMsgData);
            aVar.cd(1);
            aVar.z(oVar2);
            aVar.a(r.j.share, new m(frsActivity, oVar2, j, str, str2, shareFromFrsMsgData));
            aVar.b(r.j.alert_no_button, new n(frsActivity, oVar2));
            aVar.av(true);
            aVar.b(frsActivity.getPageContext()).tb();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                oVar2.G(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.o oVar, int i, String str, long j) {
        if (oVar != null && oVar.aIk() != null) {
            ShareFromFrsMsgData g = g(oVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.o oVar2 = new com.baidu.tieba.frs.view.o(frsActivity.getPageContext().getPageActivity());
            oVar2.setData(g);
            aVar.cd(1);
            aVar.z(oVar2);
            aVar.a(r.j.share, new o(frsActivity, oVar2, i, str, j, g));
            aVar.b(r.j.alert_no_button, new p(frsActivity, oVar2));
            aVar.av(true);
            aVar.b(frsActivity.getPageContext()).tb();
            if (!com.baidu.adp.lib.util.j.isEmpty(g.getImageUrl())) {
                oVar2.G(g.getImageUrl(), false);
            }
        }
    }
}
