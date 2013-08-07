package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1074a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.f1074a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1074a.I;
        runnable = this.f1074a.K;
        handler.removeCallbacks(runnable);
        handler2 = this.f1074a.I;
        runnable2 = this.f1074a.K;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        az azVar;
        az azVar2;
        az azVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        az azVar4;
        if (i == 0) {
            azVar3 = this.f1074a.l;
            onItemLongClickListener = this.f1074a.O;
            azVar3.a(onItemLongClickListener);
            azVar4 = this.f1074a.l;
            azVar4.f(false);
            return;
        }
        azVar = this.f1074a.l;
        azVar.a((AdapterView.OnItemLongClickListener) null);
        azVar2 = this.f1074a.l;
        azVar2.f(true);
    }
}
