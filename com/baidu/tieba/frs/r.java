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
            ctVar4 = this.a.w;
            onItemLongClickListener = this.a.am;
            ctVar4.a(onItemLongClickListener);
            ctVar5 = this.a.w;
            ctVar5.e(false);
            this.a.T = false;
            return;
        }
        ctVar = this.a.w;
        ctVar.a((AdapterView.OnItemLongClickListener) null);
        ctVar2 = this.a.w;
        ctVar2.e(true);
        this.a.T = true;
        ctVar3 = this.a.w;
        ctVar3.U();
    }
}
