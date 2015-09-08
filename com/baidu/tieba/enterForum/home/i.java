package com.baidu.tieba.enterForum.home;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements a.b {
    final /* synthetic */ d aMQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(d dVar) {
        this.aMQ = dVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.enterForum.c.c cVar;
        long j;
        TiebaStatic.eventStat(this.aMQ.aGQ.getPageContext().getPageActivity(), "recom_flist_unlike", "click", 1, new Object[0]);
        this.aMQ.aMz.Jd();
        this.aMQ.aMF = System.currentTimeMillis();
        cVar = this.aMQ.aMA;
        j = this.aMQ.aMF;
        cVar.R(j);
        aVar.dismiss();
    }
}
