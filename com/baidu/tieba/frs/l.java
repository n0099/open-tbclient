package com.baidu.tieba.frs;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity aBu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.aBu = frsActivity;
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
            buVar4 = this.aBu.aAF;
            anVar = this.aBu.aBt;
            buVar4.a(anVar);
            buVar5 = this.aBu.aAF;
            buVar5.cf(false);
            this.aBu.aAT = false;
            return;
        }
        buVar = this.aBu.aAF;
        buVar.a((com.baidu.adp.widget.ListView.an) null);
        buVar2 = this.aBu.aAF;
        buVar2.cf(true);
        this.aBu.aAT = true;
        buVar3 = this.aBu.aAF;
        buVar3.ER();
    }
}
