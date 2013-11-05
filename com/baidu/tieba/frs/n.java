package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class n implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1290a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(FrsActivity frsActivity) {
        this.f1290a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1290a.K;
        runnable = this.f1290a.M;
        handler.removeCallbacks(runnable);
        handler2 = this.f1290a.K;
        runnable2 = this.f1290a.M;
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
            baVar3 = this.f1290a.o;
            onItemLongClickListener = this.f1290a.Q;
            baVar3.a(onItemLongClickListener);
            baVar4 = this.f1290a.o;
            baVar4.f(false);
            return;
        }
        baVar = this.f1290a.o;
        baVar.a((AdapterView.OnItemLongClickListener) null);
        baVar2 = this.f1290a.o;
        baVar2.f(true);
    }
}
