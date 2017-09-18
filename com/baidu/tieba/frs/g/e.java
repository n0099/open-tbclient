package com.baidu.tieba.frs.g;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class e {
    private static ShareFromFrsMsgData e(com.baidu.tieba.tbadkCore.i iVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(iVar.aPg().getImage_url());
        shareFromFrsMsgData.setName(iVar.aPg().getName());
        shareFromFrsMsgData.setMemberNum(iVar.aPg().getMember_num());
        shareFromFrsMsgData.setPostNum(iVar.aPg().getPost_num());
        shareFromFrsMsgData.setContent(iVar.aPg().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.i iVar, final int i, final String str, final long j) {
        if (iVar != null && iVar.aPg() != null) {
            final ShareFromFrsMsgData e = e(iVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(fVar.getPageContext().getPageActivity());
            dVar.setPageId(fVar.getUniqueId());
            dVar.setData(e);
            aVar.ce(1);
            aVar.v(dVar);
            aVar.a(d.l.share, new a.b() { // from class: com.baidu.tieba.frs.g.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(com.baidu.tieba.frs.f.this.yi().getPageActivity(), i, str, j, "from_share", dVar.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.l.cancel, new a.b() { // from class: com.baidu.tieba.frs.g.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(fVar.getPageContext()).to();
            if (!com.baidu.adp.lib.util.j.isEmpty(e.getImageUrl())) {
                dVar.L(e.getImageUrl(), false);
            }
        }
    }
}
