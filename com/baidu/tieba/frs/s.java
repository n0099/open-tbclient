package com.baidu.tieba.frs;

import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class s implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        cv cvVar;
        cv cvVar2;
        cv cvVar3;
        cv cvVar4;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        cv cvVar5;
        if (i == 0) {
            cvVar4 = this.a.B;
            onItemLongClickListener = this.a.au;
            cvVar4.a(onItemLongClickListener);
            cvVar5 = this.a.B;
            cvVar5.f(false);
            this.a.Y = false;
            return;
        }
        cvVar = this.a.B;
        cvVar.a((AdapterView.OnItemLongClickListener) null);
        cvVar2 = this.a.B;
        cvVar2.f(true);
        this.a.Y = true;
        cvVar3 = this.a.B;
        cvVar3.U();
    }
}
