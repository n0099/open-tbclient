package com.baidu.tieba.frs.frsgood;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class c implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsGoodActivity bsj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(FrsGoodActivity frsGoodActivity) {
        this.bsj = frsGoodActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        boolean z;
        com.baidu.tbadk.performanceLog.e eVar;
        com.baidu.tbadk.performanceLog.e eVar2;
        com.baidu.tbadk.performanceLog.e eVar3;
        com.baidu.adp.widget.ListView.w wVar;
        if (i == 2 || i == 1) {
            z = this.bsj.bkx;
            if (!z) {
                this.bsj.bkx = true;
                this.bsj.bsd.Sf();
            }
        }
        if (i == 0) {
            y yVar = this.bsj.bsd;
            wVar = this.bsj.blg;
            yVar.a(wVar);
            this.bsj.Km = false;
        } else {
            this.bsj.bsd.a((com.baidu.adp.widget.ListView.w) null);
            this.bsj.Km = true;
        }
        eVar = this.bsj.bky;
        if (eVar == null) {
            this.bsj.bky = new com.baidu.tbadk.performanceLog.e();
            eVar3 = this.bsj.bky;
            eVar3.fh(1000);
        }
        eVar2 = this.bsj.bky;
        eVar2.GB();
    }
}
