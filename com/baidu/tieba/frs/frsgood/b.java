package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity baf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.baf = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.baf.aUm;
            if (!z) {
                this.baf.aUm = true;
                this.baf.aZZ.Mp();
            }
        }
        if (i == 0) {
            x xVar = this.baf.aZZ;
            wVar = this.baf.aUO;
            xVar.a(wVar);
            this.baf.Jk = false;
        } else {
            this.baf.aZZ.a((com.baidu.adp.widget.ListView.w) null);
            this.baf.Jk = true;
        }
        if (this.baf.aUn == null) {
            this.baf.aUn = new com.baidu.tbadk.performanceLog.e();
            this.baf.aUn.ex(1000);
        }
        this.baf.aUn.Du();
    }
}
