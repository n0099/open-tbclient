package com.baidu.tieba.frs.f;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.m;
/* loaded from: classes2.dex */
public class d {
    private static ShareFromFrsMsgData e(m mVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(mVar.bas().getImage_url());
        shareFromFrsMsgData.setName(mVar.bas().getName());
        shareFromFrsMsgData.setMemberNum(mVar.bas().getMember_num());
        shareFromFrsMsgData.setPostNum(mVar.bas().getPost_num());
        shareFromFrsMsgData.setContent(mVar.bas().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final com.baidu.tieba.frs.i iVar, m mVar, final int i, final String str, final long j) {
        if (mVar != null && mVar.bas() != null) {
            final ShareFromFrsMsgData e = e(mVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(iVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(iVar.getPageContext().getPageActivity());
            eVar.setPageId(iVar.getUniqueId());
            eVar.setData(e);
            aVar.fd(1);
            aVar.aO(eVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.i.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), eVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(com.baidu.tieba.frs.i.this.akO().getPageActivity(), i, str, j, "from_share", eVar.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.i.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), eVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ba(true);
            aVar.b(iVar.getPageContext()).AV();
            if (!k.isEmpty(e.getImageUrl())) {
                eVar.G(e.getImageUrl(), false);
            }
        }
    }
}
