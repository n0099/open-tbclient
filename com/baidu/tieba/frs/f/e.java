package com.baidu.tieba.frs.f;

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
/* loaded from: classes.dex */
public class e {
    private static ShareFromFrsMsgData e(com.baidu.tieba.tbadkCore.j jVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(jVar.aPU().getImage_url());
        shareFromFrsMsgData.setName(jVar.aPU().getName());
        shareFromFrsMsgData.setMemberNum(jVar.aPU().getMember_num());
        shareFromFrsMsgData.setPostNum(jVar.aPU().getPost_num());
        shareFromFrsMsgData.setContent(jVar.aPU().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final com.baidu.tieba.frs.f fVar, com.baidu.tieba.tbadkCore.j jVar, final int i, final String str, final long j) {
        if (jVar != null && jVar.aPU() != null) {
            final ShareFromFrsMsgData e = e(jVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(fVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.d dVar = new com.baidu.tieba.frs.view.d(fVar.getPageContext().getPageActivity());
            dVar.setPageId(fVar.getUniqueId());
            dVar.setData(e);
            aVar.ce(1);
            aVar.v(dVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.f.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(com.baidu.tieba.frs.f.this.xP().getPageActivity(), i, str, j, "from_share", dVar.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.f.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), dVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(fVar.getPageContext()).th();
            if (!k.isEmpty(e.getImageUrl())) {
                dVar.G(e.getImageUrl(), false);
            }
        }
    }
}
