package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity bkp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsGoodActivity frsGoodActivity) {
        this.bkp = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.bkp.bdv;
            if (!z) {
                this.bkp.bdv = true;
                this.bkp.bkj.Oj();
            }
        }
        if (i == 0) {
            x xVar = this.bkp.bkj;
            wVar = this.bkp.bdZ;
            xVar.a(wVar);
            this.bkp.JR = false;
        } else {
            this.bkp.bkj.a((com.baidu.adp.widget.ListView.w) null);
            this.bkp.JR = true;
        }
        if (this.bkp.bdw == null) {
            this.bkp.bdw = new com.baidu.tbadk.performanceLog.e();
            this.bkp.bdw.eF(1000);
        }
        this.bkp.bdw.Ek();
    }
}
