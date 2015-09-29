package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity aZB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.aZB = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.aZB.aTT;
            if (!z) {
                this.aZB.aTT = true;
                this.aZB.aZv.Md();
            }
        }
        if (i == 0) {
            x xVar = this.aZB.aZv;
            wVar = this.aZB.aUv;
            xVar.a(wVar);
            this.aZB.Ji = false;
        } else {
            this.aZB.aZv.a((com.baidu.adp.widget.ListView.w) null);
            this.aZB.Ji = true;
        }
        if (this.aZB.aTU == null) {
            this.aZB.aTU = new com.baidu.tbadk.performanceLog.e();
            this.aZB.aTU.ez(1000);
        }
        this.aZB.aTU.DE();
    }
}
