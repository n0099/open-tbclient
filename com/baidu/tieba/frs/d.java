package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aLX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.aLX = frsActivity;
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
        aVar = this.aLX.aLA;
        if (aVar != null) {
            aVar2 = this.aLX.aLA;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aLX.aLu;
            if (!z) {
                this.aLX.aLu = true;
                bfVar = this.aLX.aLi;
                bfVar.Lz();
            }
        }
        if (this.aLX.aLv == null) {
            this.aLX.aLv = new com.baidu.tbadk.performanceLog.h();
            this.aLX.aLv.el(1000);
        }
        if (i == 0) {
            bfVar4 = this.aLX.aLi;
            akVar = this.aLX.aLT;
            bfVar4.a(akVar);
            bfVar5 = this.aLX.aLi;
            bfVar5.cc(false);
            this.aLX.Jf = false;
        } else {
            bfVar2 = this.aLX.aLi;
            bfVar2.a((com.baidu.adp.widget.ListView.ak) null);
            bfVar3 = this.aLX.aLi;
            bfVar3.cc(true);
            this.aLX.Jf = true;
        }
        this.aLX.aLv.De();
    }
}
