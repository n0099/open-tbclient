package com.baidu.tieba.frs.f;

import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.data.ShareFromFrsMsgData;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes6.dex */
public class e {
    private static ShareFromFrsMsgData g(l lVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(lVar.bgi().getImage_url());
        shareFromFrsMsgData.setName(lVar.bgi().getName());
        shareFromFrsMsgData.setMemberNum(lVar.bgi().getMember_num());
        shareFromFrsMsgData.setPostNum(lVar.bgi().getPost_num());
        shareFromFrsMsgData.setContent(lVar.bgi().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final FrsFragment frsFragment, l lVar, final long j, final String str, final long j2) {
        if (lVar != null && lVar.bgi() != null) {
            final ShareFromFrsMsgData g = g(lVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsFragment.getPageContext().getPageActivity());
            final FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
            frsShareCardView.setPageId(frsFragment.getUniqueId());
            frsShareCardView.setData(g);
            aVar.dd(1);
            aVar.G(frsShareCardView);
            aVar.a(e.j.share, new a.b() { // from class: com.baidu.tieba.frs.f.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(FrsFragment.this.getTbPageContext().getPageActivity(), j, str, j2, "from_share", frsShareCardView.getLeaveMsg(), g.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(e.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.bg(true);
            aVar.b(frsFragment.getPageContext()).BF();
            if (!k.isEmpty(g.getImageUrl())) {
                frsShareCardView.N(g.getImageUrl(), false);
            }
        }
    }
}
