package com.baidu.tieba.frs;

import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class r implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ct ctVar4;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        ct ctVar5;
        if (i == 0) {
            ctVar4 = this.a.v;
            onItemLongClickListener = this.a.aq;
            ctVar4.a(onItemLongClickListener);
            ctVar5 = this.a.v;
            ctVar5.e(false);
            this.a.S = false;
            return;
        }
        ctVar = this.a.v;
        ctVar.a((AdapterView.OnItemLongClickListener) null);
        ctVar2 = this.a.v;
        ctVar2.e(true);
        this.a.S = true;
        ctVar3 = this.a.v;
        ctVar3.T();
    }
}
