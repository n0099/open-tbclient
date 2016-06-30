package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.dc;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumRequest;
import com.baidu.tieba.u;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bKk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bKk = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a aVar;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a aVar2;
        List<dc> list;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a aVar3;
        i iVar;
        FrsActivity frsActivity;
        FrsActivity frsActivity2;
        GetFrsTabFollowPostNumRequest getFrsTabFollowPostNumRequest;
        FrsActivity frsActivity3;
        GetFrsTabFollowPostNumRequest getFrsTabFollowPostNumRequest2;
        FrsActivity frsActivity4;
        GetFrsTabFollowPostNumRequest getFrsTabFollowPostNumRequest3;
        FrsActivity frsActivity5;
        c.b bVar;
        FrsActivity frsActivity6;
        if (!com.baidu.adp.lib.util.i.ff()) {
            frsActivity6 = this.bKk.bKb;
            frsActivity6.showToast(u.j.neterror);
            return;
        }
        aVar = this.bKk.bKe;
        if (aVar == null) {
            a aVar4 = this.bKk;
            frsActivity5 = this.bKk.bKb;
            bVar = this.bKk.bKj;
            aVar4.bKe = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a(frsActivity5, bVar);
        }
        aVar2 = this.bKk.bKe;
        list = this.bKk.bKd;
        aVar2.setData(list);
        aVar3 = this.bKk.bKe;
        iVar = this.bKk.bKb;
        aVar3.d(iVar.getPageContext()).rW();
        frsActivity = this.bKk.bKb;
        if (frsActivity.VC() != null) {
            frsActivity2 = this.bKk.bKb;
            if (frsActivity2.VC().aDN() != null) {
                getFrsTabFollowPostNumRequest = this.bKk.bKh;
                if (getFrsTabFollowPostNumRequest == null) {
                    a aVar5 = this.bKk;
                    frsActivity3 = this.bKk.bKb;
                    aVar5.bKh = new GetFrsTabFollowPostNumRequest(frsActivity3.getUniqueId());
                    getFrsTabFollowPostNumRequest2 = this.bKk.bKh;
                    frsActivity4 = this.bKk.bKb;
                    getFrsTabFollowPostNumRequest2.setFid(frsActivity4.VC().aDN().getId());
                    MessageManager messageManager = MessageManager.getInstance();
                    getFrsTabFollowPostNumRequest3 = this.bKk.bKh;
                    messageManager.sendMessage(getFrsTabFollowPostNumRequest3);
                }
            }
        }
    }
}
