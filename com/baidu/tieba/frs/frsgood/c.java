package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class c implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGoodActivity frsGoodActivity) {
        this.bnm = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.bnm.bfM;
            if (!z) {
                this.bnm.bfM = true;
                this.bnm.bng.Qm();
            }
        }
        if (i == 0) {
            y yVar = this.bnm.bng;
            wVar = this.bnm.bgv;
            yVar.a(wVar);
            this.bnm.Kg = false;
        } else {
            this.bnm.bng.a((com.baidu.adp.widget.ListView.w) null);
            this.bnm.Kg = true;
        }
        if (this.bnm.bfN == null) {
            this.bnm.bfN = new com.baidu.tbadk.performanceLog.e();
            this.bnm.bfN.eZ(1000);
        }
        this.bnm.bfN.FF();
    }
}
