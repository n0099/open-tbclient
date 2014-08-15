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
        cu cuVar;
        cu cuVar2;
        cu cuVar3;
        cu cuVar4;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        cu cuVar5;
        if (i == 0) {
            cuVar4 = this.a.z;
            onItemLongClickListener = this.a.as;
            cuVar4.a(onItemLongClickListener);
            cuVar5 = this.a.z;
            cuVar5.f(false);
            this.a.W = false;
            return;
        }
        cuVar = this.a.z;
        cuVar.a((AdapterView.OnItemLongClickListener) null);
        cuVar2 = this.a.z;
        cuVar2.f(true);
        this.a.W = true;
        cuVar3 = this.a.z;
        cuVar3.U();
    }
}
