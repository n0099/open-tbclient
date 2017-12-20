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
    private static ShareFromFrsMsgData f(k kVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(kVar.aRn().getImage_url());
        shareFromFrsMsgData.setName(kVar.aRn().getName());
        shareFromFrsMsgData.setMemberNum(kVar.aRn().getMember_num());
        shareFromFrsMsgData.setPostNum(kVar.aRn().getPost_num());
        shareFromFrsMsgData.setContent(kVar.aRn().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final com.baidu.tieba.frs.g gVar, k kVar, final int i, final String str, final long j) {
        if (kVar != null && kVar.aRn() != null) {
            final ShareFromFrsMsgData f = f(kVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(gVar.getPageContext().getPageActivity());
            final com.baidu.tieba.frs.view.e eVar = new com.baidu.tieba.frs.view.e(gVar.getPageContext().getPageActivity());
            eVar.setPageId(gVar.getUniqueId());
            eVar.setData(f);
            aVar.cf(1);
            aVar.v(eVar);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.g.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), eVar.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new GroupChatActivityConfig(com.baidu.tieba.frs.g.this.xR().getPageActivity(), i, str, j, "from_share", eVar.getLeaveMsg(), f.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    com.baidu.tieba.frs.g.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), eVar.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.ap(true);
            aVar.b(gVar.getPageContext()).th();
            if (!com.baidu.adp.lib.util.k.isEmpty(f.getImageUrl())) {
                eVar.I(f.getImageUrl(), false);
            }
        }
    }
}
