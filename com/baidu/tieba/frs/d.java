package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aJQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.aJQ = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.c.a aVar;
        boolean z;
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        com.baidu.adp.widget.ListView.ak akVar;
        bf bfVar5;
        com.baidu.tieba.frs.c.a aVar2;
        aVar = this.aJQ.aJt;
        if (aVar != null) {
            aVar2 = this.aJQ.aJt;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aJQ.aJm;
            if (!z) {
                this.aJQ.aJm = true;
                bfVar = this.aJQ.aJa;
                bfVar.Kt();
            }
        }
        if (this.aJQ.aJn == null) {
            this.aJQ.aJn = new com.baidu.tbadk.performanceLog.h();
            this.aJQ.aJn.eb(1000);
            this.aJQ.aJn.apt = this.aJQ.aJq;
        }
        if (i == 0) {
            bfVar4 = this.aJQ.aJa;
            akVar = this.aJQ.aJM;
            bfVar4.a(akVar);
            bfVar5 = this.aJQ.aJa;
            bfVar5.bT(false);
            this.aJQ.Jo = false;
        } else {
            bfVar2 = this.aJQ.aJa;
            bfVar2.a((com.baidu.adp.widget.ListView.ak) null);
            bfVar3 = this.aJQ.aJa;
            bfVar3.bT(true);
            this.aJQ.Jo = true;
        }
        this.aJQ.aJn.Ct();
    }
}
