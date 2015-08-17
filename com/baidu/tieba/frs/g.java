package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class g implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(FrsActivity frsActivity) {
        this.this$0 = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        com.baidu.tieba.frs.c.a aVar;
        aVar = this.this$0.aUM;
        aVar.onScroll(absListView, i, i2, i3);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        com.baidu.tieba.frs.c.a aVar;
        boolean z;
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        com.baidu.adp.widget.ListView.w wVar;
        bl blVar5;
        com.baidu.tieba.frs.c.a aVar2;
        aVar = this.this$0.aUM;
        if (aVar != null) {
            aVar2 = this.this$0.aUM;
            aVar2.setScrollState(i);
        }
        if (i == 2 || i == 1) {
            z = this.this$0.aUG;
            if (!z) {
                this.this$0.aUG = true;
                blVar = this.this$0.aUw;
                blVar.Mn();
            }
        }
        if (this.this$0.aUH == null) {
            this.this$0.aUH = new com.baidu.tbadk.performanceLog.e();
            this.this$0.aUH.eq(1000);
        }
        if (i == 0) {
            blVar4 = this.this$0.aUw;
            wVar = this.this$0.aVh;
            blVar4.a(wVar);
            blVar5 = this.this$0.aUw;
            blVar5.cd(false);
            this.this$0.Ji = false;
        } else {
            blVar2 = this.this$0.aUw;
            blVar2.a((com.baidu.adp.widget.ListView.w) null);
            blVar3 = this.this$0.aUw;
            blVar3.cd(true);
            this.this$0.Ji = true;
        }
        this.this$0.aUH.DH();
    }
}
