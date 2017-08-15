package com.baidu.tieba.frs.f;

import android.content.Intent;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    public static void a(com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, Intent intent) {
        a(fVar, iVar, e(iVar), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT));
    }

    private static ShareFromFrsMsgData e(com.baidu.tieba.tbadkCore.i iVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(iVar.aPO().getImage_url());
        shareFromFrsMsgData.setName(iVar.aPO().getName());
        shareFromFrsMsgData.setMemberNum(iVar.aPO().getMember_num());
        shareFromFrsMsgData.setPostNum(iVar.aPO().getPost_num());
        shareFromFrsMsgData.setContent(iVar.aPO().getSlogan());
        return shareFromFrsMsgData;
    }

    private static void a(final com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, final ShareFromFrsMsgData shareFromFrsMsgData, final long j, final String str, final String str2) {
        if (iVar != null && iVar.aPO() != null) {
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(fVar.getPageContext().getPageActivity());
            dVar.setPageId(fVar.getUniqueId());
            dVar.setData(shareFromFrsMsgData);
            aVar.ce(1);
            aVar.v(dVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.frs.f.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PERSONAL_CHAT, new PersonalChatActivityConfig(com.baidu.tieba.frs.f.this.getPageContext().getPageActivity(), j, str, str2, 0, dVar.getLeaveMsg(), shareFromFrsMsgData.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.frs.f.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(fVar.getPageContext()).tr();
            if (!com.baidu.adp.lib.util.j.isEmpty(shareFromFrsMsgData.getImageUrl())) {
                dVar.K(shareFromFrsMsgData.getImageUrl(), false);
            }
        }
    }

    public static void a(final com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, final int i, final String str, final long j) {
        if (iVar != null && iVar.aPO() != null) {
            final ShareFromFrsMsgData e = e(iVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(fVar.getPageContext().getPageActivity());
            dVar.setPageId(fVar.getUniqueId());
            dVar.setData(e);
            aVar.ce(1);
            aVar.v(dVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.frs.f.e.3
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(com.baidu.tieba.frs.f.this.yg().getPageActivity(), i, str, j, "from_share", dVar.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.alert_no_button, new a.b() { // from class: com.baidu.tieba.frs.f.e.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(fVar.getPageContext()).tr();
            if (!com.baidu.adp.lib.util.j.isEmpty(e.getImageUrl())) {
                dVar.K(e.getImageUrl(), false);
            }
        }
    }
}
