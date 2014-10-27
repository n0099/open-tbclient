package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aBk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.aBk = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        bu buVar;
        bu buVar2;
        bu buVar3;
        bu buVar4;
        com.baidu.adp.widget.ListView.an anVar;
        bu buVar5;
        if (i == 0) {
            buVar4 = this.aBk.aAv;
            anVar = this.aBk.aBj;
            buVar4.a(anVar);
            buVar5 = this.aBk.aAv;
            buVar5.cf(false);
            this.aBk.aAJ = false;
            return;
        }
        buVar = this.aBk.aAv;
        buVar.a((com.baidu.adp.widget.ListView.an) null);
        buVar2 = this.aBk.aAv;
        buVar2.cf(true);
        this.aBk.aAJ = true;
        buVar3 = this.aBk.aAv;
        buVar3.EP();
    }
}
