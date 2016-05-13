package com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost;

import android.view.View;
import com.baidu.adp.base.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.core.dialog.c;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.em;
import com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.model.GetFrsTabFollowPostNumRequest;
import com.baidu.tieba.t;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements View.OnClickListener {
    final /* synthetic */ a bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.bpB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a aVar;
        com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a aVar2;
        List<em> list;
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
        if (!com.baidu.adp.lib.util.i.fe()) {
            frsActivity6 = this.bpB.bpt;
            frsActivity6.showToast(t.j.neterror);
            return;
        }
        aVar = this.bpB.bpw;
        if (aVar == null) {
            a aVar4 = this.bpB;
            frsActivity5 = this.bpB.bpt;
            bVar = this.bpB.bpA;
            aVar4.bpw = new com.baidu.tieba.frs.entelechy.tabView.frsTabFollowPost.a.a(frsActivity5, bVar);
        }
        aVar2 = this.bpB.bpw;
        list = this.bpB.bpv;
        aVar2.setData(list);
        aVar3 = this.bpB.bpw;
        iVar = this.bpB.bpt;
        aVar3.d(iVar.getPageContext()).rY();
        frsActivity = this.bpB.bpt;
        if (frsActivity.PZ() != null) {
            frsActivity2 = this.bpB.bpt;
            if (frsActivity2.PZ().avD() != null) {
                getFrsTabFollowPostNumRequest = this.bpB.bpy;
                if (getFrsTabFollowPostNumRequest == null) {
                    a aVar5 = this.bpB;
                    frsActivity3 = this.bpB.bpt;
                    aVar5.bpy = new GetFrsTabFollowPostNumRequest(frsActivity3.getUniqueId());
                    getFrsTabFollowPostNumRequest2 = this.bpB.bpy;
                    frsActivity4 = this.bpB.bpt;
                    getFrsTabFollowPostNumRequest2.setFid(frsActivity4.PZ().avD().getId());
                    MessageManager messageManager = MessageManager.getInstance();
                    getFrsTabFollowPostNumRequest3 = this.bpB.bpy;
                    messageManager.sendMessage(getFrsTabFollowPostNumRequest3);
                }
            }
        }
    }
}
