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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class cl {
    public static void a(TbPageContext tbPageContext, com.baidu.tieba.tbadkCore.p pVar, String str) {
        String name;
        if (tbPageContext != null && pVar != null && pVar.aLP() != null) {
            if (pVar.aLP().getName() == null) {
                tbPageContext.showToast(tbPageContext.getString(t.j.no_forum_data));
                return;
            }
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "frs_share", "frsclick", 1, new Object[0]);
            String str2 = "http://tieba.baidu.com/f?kw=" + pVar.aLP().getName();
            Uri parse = pVar.aLP().getImage_url() == null ? null : Uri.parse(pVar.aLP().getImage_url());
            String slogan = pVar.aLP().getSlogan();
            com.baidu.tbadk.coreExtra.share.f fVar = new com.baidu.tbadk.coreExtra.share.f();
            fVar.title = String.valueOf(name) + tbPageContext.getString(t.j.forum);
            fVar.content = slogan;
            fVar.linkUrl = str2;
            fVar.anj = true;
            fVar.extData = str;
            if (parse != null) {
                fVar.imageUri = parse;
            }
            ShareDialogConfig shareDialogConfig = new ShareDialogConfig(tbPageContext.getPageActivity(), fVar, true);
            shareDialogConfig.addOutsideTextView(t.j.share_tieba_qunzu, t.f.icon_unite_share_qunzu, new cm(tbPageContext, str));
            shareDialogConfig.addOutsideTextView(t.j.forum_friend, t.f.icon_unite_share_baf, new cn(tbPageContext, str));
            shareDialogConfig.setCopyLinkListener(new co(fVar, tbPageContext));
            tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, Intent intent) {
        a(frsActivity, pVar, b(pVar), intent.getLongExtra("key_user_id", -1L), intent.getStringExtra("key_user_name"), intent.getStringExtra("key_user_portait"));
    }

    private static ShareFromFrsMsgData b(com.baidu.tieba.tbadkCore.p pVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(pVar.aLP().getImage_url());
        shareFromFrsMsgData.setName(pVar.aLP().getName());
        shareFromFrsMsgData.setMemberNum(pVar.aLP().getMember_num());
        shareFromFrsMsgData.setPostNum(pVar.aLP().getPost_num());
        shareFromFrsMsgData.setContent(pVar.aLP().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, ShareFromFrsMsgData shareFromFrsMsgData, long j, String str, String str2) {
        if (pVar != null && pVar.aLP() != null) {
            a aVar = new a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.n nVar = new com.baidu.tieba.frs.view.n(frsActivity.getPageContext().getPageActivity());
            nVar.setData(shareFromFrsMsgData);
            aVar.cb(1);
            aVar.z(nVar);
            aVar.a(t.j.share, new cp(frsActivity, nVar, j, str, str2, shareFromFrsMsgData));
            aVar.b(t.j.alert_no_button, new cq(frsActivity, nVar));
            aVar.ar(true);
            aVar.b(frsActivity.getPageContext()).sX();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                nVar.E(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(FrsActivity frsActivity, com.baidu.tieba.tbadkCore.p pVar, int i, String str, long j) {
        if (pVar != null && pVar.aLP() != null) {
            ShareFromFrsMsgData b = b(pVar);
            a aVar = new a(frsActivity.getPageContext().getPageActivity());
            com.baidu.tieba.frs.view.n nVar = new com.baidu.tieba.frs.view.n(frsActivity.getPageContext().getPageActivity());
            nVar.setData(b);
            aVar.cb(1);
            aVar.z(nVar);
            aVar.a(t.j.share, new cr(frsActivity, nVar, i, str, j, b));
            aVar.b(t.j.alert_no_button, new cs(frsActivity, nVar));
            aVar.ar(true);
            aVar.b(frsActivity.getPageContext()).sX();
            if (!com.baidu.adp.lib.util.j.isEmpty(b.getImageUrl())) {
                nVar.E(b.getImageUrl(), false);
            }
        }
    }
}
