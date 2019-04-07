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
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class e {
    private static ShareFromFrsMsgData g(FrsViewData frsViewData) {
        ShareFromFrsMsgData shareFromFrsMsgData = new ShareFromFrsMsgData();
        shareFromFrsMsgData.setImageUrl(frsViewData.getForum().getImage_url());
        shareFromFrsMsgData.setName(frsViewData.getForum().getName());
        shareFromFrsMsgData.setMemberNum(frsViewData.getForum().getMember_num());
        shareFromFrsMsgData.setPostNum(frsViewData.getForum().getPost_num());
        shareFromFrsMsgData.setContent(frsViewData.getForum().getSlogan());
        return shareFromFrsMsgData;
    }

    public static void a(final FrsFragment frsFragment, FrsViewData frsViewData, final long j, final String str, final long j2) {
        if (frsViewData != null && frsViewData.getForum() != null) {
            final ShareFromFrsMsgData g = g(frsViewData);
            com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(frsFragment.getPageContext().getPageActivity());
            final FrsShareCardView frsShareCardView = new FrsShareCardView(frsFragment.getPageContext().getPageActivity());
            frsShareCardView.setPageId(frsFragment.getUniqueId());
            frsShareCardView.setData(g);
            aVar.gE(1);
            aVar.az(frsShareCardView);
            aVar.a(d.j.share, new a.b() { // from class: com.baidu.tieba.frs.f.e.1
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GroupChatActivityConfig(FrsFragment.this.getTbPageContext().getPageActivity(), j, str, j2, "from_share", frsShareCardView.getLeaveMsg(), g.toChatMessageContent())));
                    aVar2.dismiss();
                }
            });
            aVar.b(d.j.cancel, new a.b() { // from class: com.baidu.tieba.frs.f.e.2
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    FrsFragment.this.HidenSoftKeyPad((InputMethodManager) TbadkCoreApplication.getInst().getSystemService("input_method"), frsShareCardView.getChatMsgView());
                    aVar2.dismiss();
                }
            });
            aVar.dr(true);
            aVar.b(frsFragment.getPageContext()).aaW();
            if (!k.isEmpty(g.getImageUrl())) {
                frsShareCardView.ag(g.getImageUrl(), false);
            }
        }
    }
}
