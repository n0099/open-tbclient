package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity bgy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.bgy = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.bgy.aZz;
            if (!z) {
                this.bgy.aZz = true;
                this.bgy.bgr.NQ();
            }
        }
        if (i == 0) {
            x xVar = this.bgy.bgr;
            wVar = this.bgy.bac;
            xVar.a(wVar);
            this.bgy.JB = false;
        } else {
            this.bgy.bgr.a((com.baidu.adp.widget.ListView.w) null);
            this.bgy.JB = true;
        }
        if (this.bgy.aZA == null) {
            this.bgy.aZA = new com.baidu.tbadk.performanceLog.e();
            this.bgy.aZA.eL(1000);
        }
        this.bgy.aZA.Ev();
    }
}
