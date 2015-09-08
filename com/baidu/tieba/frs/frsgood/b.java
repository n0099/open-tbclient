package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity aZI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.aZI = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.aZI.aUV;
            if (!z) {
                this.aZI.aUV = true;
                this.aZI.aZC.Me();
            }
        }
        if (i == 0) {
            x xVar = this.aZI.aZC;
            wVar = this.aZI.aVv;
            xVar.a(wVar);
            this.aZI.Ji = false;
        } else {
            this.aZI.aZC.a((com.baidu.adp.widget.ListView.w) null);
            this.aZI.Ji = true;
        }
        if (this.aZI.aUW == null) {
            this.aZI.aUW = new com.baidu.tbadk.performanceLog.e();
        }
        this.aZI.aUW.ey(1000);
        this.aZI.aUW.DR();
    }
}
