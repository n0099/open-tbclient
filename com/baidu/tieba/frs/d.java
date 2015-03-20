package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aJG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FrsActivity frsActivity) {
        this.aJG = frsActivity;
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
        aVar = this.aJG.aJl;
        if (aVar != null) {
            aVar2 = this.aJG.aJl;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aJG.aJe;
            if (!z) {
                this.aJG.aJe = true;
                bfVar = this.aJG.aIS;
                bfVar.Km();
            }
        }
        if (this.aJG.aJf == null) {
            this.aJG.aJf = new com.baidu.tbadk.performanceLog.h();
            this.aJG.aJf.eb(1000);
            this.aJG.aJf.apk = this.aJG.aJi;
        }
        if (i == 0) {
            bfVar4 = this.aJG.aIS;
            akVar = this.aJG.aJC;
            bfVar4.a(akVar);
            bfVar5 = this.aJG.aIS;
            bfVar5.bV(false);
            this.aJG.Jm = false;
        } else {
            bfVar2 = this.aJG.aIS;
            bfVar2.a((com.baidu.adp.widget.ListView.ak) null);
            bfVar3 = this.aJG.aIS;
            bfVar3.bV(true);
            this.aJG.Jm = true;
        }
        this.aJG.aJf.Cn();
    }
}
