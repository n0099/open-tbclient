package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aLY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.aLY = frsActivity;
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
        aVar = this.aLY.aLB;
        if (aVar != null) {
            aVar2 = this.aLY.aLB;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aLY.aLv;
            if (!z) {
                this.aLY.aLv = true;
                bfVar = this.aLY.aLj;
                bfVar.LA();
            }
        }
        if (this.aLY.aLw == null) {
            this.aLY.aLw = new com.baidu.tbadk.performanceLog.h();
            this.aLY.aLw.el(1000);
        }
        if (i == 0) {
            bfVar4 = this.aLY.aLj;
            akVar = this.aLY.aLU;
            bfVar4.a(akVar);
            bfVar5 = this.aLY.aLj;
            bfVar5.cc(false);
            this.aLY.Jf = false;
        } else {
            bfVar2 = this.aLY.aLj;
            bfVar2.a((com.baidu.adp.widget.ListView.ak) null);
            bfVar3 = this.aLY.aLj;
            bfVar3.cc(true);
            this.aLY.Jf = true;
        }
        this.aLY.aLw.Df();
    }
}
