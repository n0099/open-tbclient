package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements a.b {
    final /* synthetic */ l bqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar) {
        this.bqi = lVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.bqi.aVu.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.bqi.bpQ.TU();
        this.bqi.bpX = System.currentTimeMillis();
        cVar = this.bqi.bpR;
        j = this.bqi.bpX;
        cVar.aP(j);
        aVar.dismiss();
    }
}
