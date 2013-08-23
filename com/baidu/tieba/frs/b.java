package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class b implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1088a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(FrsActivity frsActivity) {
        this.f1088a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1088a.L;
        runnable = this.f1088a.N;
        handler.removeCallbacks(runnable);
        handler2 = this.f1088a.L;
        runnable2 = this.f1088a.N;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        bb bbVar;
        bb bbVar2;
        bb bbVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        bb bbVar4;
        if (i == 0) {
            bbVar3 = this.f1088a.l;
            onItemLongClickListener = this.f1088a.R;
            bbVar3.a(onItemLongClickListener);
            bbVar4 = this.f1088a.l;
            bbVar4.f(false);
            return;
        }
        bbVar = this.f1088a.l;
        bbVar.a((AdapterView.OnItemLongClickListener) null);
        bbVar2 = this.f1088a.l;
        bbVar2.f(true);
    }
}
