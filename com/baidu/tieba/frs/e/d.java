package com.baidu.tieba.frs.e;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class d {
    private static ShareFromFrsMsgData e(l lVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(lVar.aYE().getImage_url());
        shareFromFrsMsgData.setName(lVar.aYE().getName());
        shareFromFrsMsgData.setMemberNum(lVar.aYE().getMember_num());
        shareFromFrsMsgData.setPostNum(lVar.aYE().getPost_num());
        shareFromFrsMsgData.setContent(lVar.aYE().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final com.baidu.tieba.frs.i iVar, l lVar, final int i, final String str, final long j) {
        if (lVar != null && lVar.aYE() != null) {
            final ShareFromFrsMsgData e = e(lVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(iVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(iVar.getPageContext().getPageActivity());
            eVar.setPageId(iVar.getUniqueId());
            eVar.setData(e);
            aVar.fd(1);
            aVar.aO(eVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.e.d.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.i.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), eVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(com.baidu.tieba.frs.i.this.aka().getPageActivity(), i, str, j, "from_share", eVar.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.e.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.i.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), eVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.aW(true);
            aVar.b(iVar.getPageContext()).AA();
            if (!k.isEmpty(e.getImageUrl())) {
                eVar.J(e.getImageUrl(), false);
            }
        }
    }
}
