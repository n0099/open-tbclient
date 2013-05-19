package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.I;
        runnable = this.a.K;
        handler.removeCallbacks(runnable);
        handler2 = this.a.I;
        runnable2 = this.a.K;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        ba baVar;
        ba baVar2;
        ba baVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        ba baVar4;
        if (i == 0) {
            baVar3 = this.a.l;
            onItemLongClickListener = this.a.O;
            baVar3.a(onItemLongClickListener);
            baVar4 = this.a.l;
            baVar4.e(false);
            return;
        }
        baVar = this.a.l;
        baVar.a((AdapterView.OnItemLongClickListener) null);
        baVar2 = this.a.l;
        baVar2.e(true);
    }
}
