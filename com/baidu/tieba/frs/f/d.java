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
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.view.FrsShareCardView;
import com.baidu.tieba.tbadkCore.l;
/* loaded from: classes2.dex */
public class d {
    private static ShareFromFrsMsgData e(l lVar) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(lVar.aVq().getImage_url());
        shareFromFrsMsgData.setName(lVar.aVq().getName());
        shareFromFrsMsgData.setMemberNum(lVar.aVq().getMember_num());
        shareFromFrsMsgData.setPostNum(lVar.aVq().getPost_num());
        shareFromFrsMsgData.setContent(lVar.aVq().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final FrsFragment frsFragment, l lVar, final long j, final String str, final long j2) {
        if (lVar != null && lVar.aVq() != null) {
            final ShareFromFrsMsgData e = e(lVar);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsFragment.getPageContext().getPageActivity());
            final FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
            frsShareCardView.setPageId(frsFragment.getUniqueId());
            frsShareCardView.setData(e);
            aVar.cc(1);
            aVar.w(frsShareCardView);
            aVar.a(d.k.share, new a.b() { // from class: com.baidu.tieba.frs.f.d.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(FrsFragment.this.aeY().getPageActivity(), j, str, j2, "from_share", frsShareCardView.getLeaveMsg(), e.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.k.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.d.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.as(true);
            aVar.b(frsFragment.getPageContext()).tD();
            if (!k.isEmpty(e.getImageUrl())) {
                frsShareCardView.D(e.getImageUrl(), false);
            }
        }
    }
}
