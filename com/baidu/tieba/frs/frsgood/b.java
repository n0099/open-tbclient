package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity aZM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.aZM = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.aZM.aUe;
            if (!z) {
                this.aZM.aUe = true;
                this.aZM.aZG.Md();
            }
        }
        if (i == 0) {
            x xVar = this.aZM.aZG;
            wVar = this.aZM.aUG;
            xVar.a(wVar);
            this.aZM.Jj = false;
        } else {
            this.aZM.aZG.a((com.baidu.adp.widget.ListView.w) null);
            this.aZM.Jj = true;
        }
        if (this.aZM.aUf == null) {
            this.aZM.aUf = new com.baidu.tbadk.performanceLog.e();
            this.aZM.aUf.ez(1000);
        }
        this.aZM.aUf.DE();
    }
}
