package com.baidu.tieba.frs.f;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.k;
/* loaded from: classes.dex */
public class d {
    private static ShareFromFrsMsgData e(k kVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(kVar.aRf().getImage_url());
        shareFromFrsMsgData.setName(kVar.aRf().getName());
        shareFromFrsMsgData.setMemberNum(kVar.aRf().getMember_num());
        shareFromFrsMsgData.setPostNum(kVar.aRf().getPost_num());
        shareFromFrsMsgData.setContent(kVar.aRf().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final com.baidu.tieba.frs.f fVar, k kVar, final int i, final String str, final long j) {
        if (kVar != null && kVar.aRf() != null) {
            final ShareFromFrsMsgData e = e(kVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(fVar.getPageContext().getPageActivity());
            dVar.setPageId(fVar.getUniqueId());
            dVar.setData(e);
            aVar.cf(1);
            aVar.v(dVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(com.baidu.tieba.frs.f.this.xQ().getPageActivity(), i, str, j, "from_share", dVar.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(fVar.getPageContext()).tk();
            if (!com.baidu.adp.lib.util.k.isEmpty(e.getImageUrl())) {
                dVar.H(e.getImageUrl(), false);
            }
        }
    }
}
