package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity aZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.aZp = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.aZp.aUG;
            if (!z) {
                this.aZp.aUG = true;
                this.aZp.aZj.Mn();
            }
        }
        if (i == 0) {
            x xVar = this.aZp.aZj;
            wVar = this.aZp.aVh;
            xVar.a(wVar);
            this.aZp.Ji = false;
        } else {
            this.aZp.aZj.a((com.baidu.adp.widget.ListView.w) null);
            this.aZp.Ji = true;
        }
        if (this.aZp.aUH == null) {
            this.aZp.aUH = new com.baidu.tbadk.performanceLog.e();
        }
        this.aZp.aUH.eq(1000);
        this.aZp.aUH.DH();
    }
}
