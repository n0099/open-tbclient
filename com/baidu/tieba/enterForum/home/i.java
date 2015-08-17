package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d aMD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.aMD = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aMD.aGD.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aMD.aMm.Jp();
        this.aMD.aMs = System.currentTimeMillis();
        cVar = this.aMD.aMn;
        j = this.aMD.aMs;
        cVar.Q(j);
        aVar.dismiss();
    }
}
