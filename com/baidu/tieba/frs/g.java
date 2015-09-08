package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aVz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.aVz = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.c.a aVar;
        aVar = this.aVz.aVb;
        aVar.onScroll(absListView, i, i2, i3);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.c.a aVar;
        boolean z;
        bi biVar;
        bi biVar2;
        bi biVar3;
        bi biVar4;
        com.baidu.adp.widget.ListView.w wVar;
        bi biVar5;
        com.baidu.tieba.frs.c.a aVar2;
        aVar = this.aVz.aVb;
        if (aVar != null) {
            aVar2 = this.aVz.aVb;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.aVz.aUV;
            if (!z) {
                this.aVz.aUV = true;
                biVar = this.aVz.aUL;
                biVar.Me();
            }
        }
        if (this.aVz.aUW == null) {
            this.aVz.aUW = new com.baidu.tbadk.performanceLog.e();
            this.aVz.aUW.ey(1000);
        }
        if (i == 0) {
            biVar4 = this.aVz.aUL;
            wVar = this.aVz.aVv;
            biVar4.a(wVar);
            biVar5 = this.aVz.aUL;
            biVar5.ci(false);
            this.aVz.Ji = false;
        } else {
            biVar2 = this.aVz.aUL;
            biVar2.a((com.baidu.adp.widget.ListView.w) null);
            biVar3 = this.aVz.aUL;
            biVar3.ci(true);
            this.aVz.Ji = true;
        }
        this.aVz.aUW.DR();
    }
}
