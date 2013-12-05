package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrsActivity f1416a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.f1416a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        bn bnVar;
        bn bnVar2;
        Handler handler2;
        bn bnVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        bn bnVar4;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.f1416a.N;
        if (handler != null) {
            handler4 = this.f1416a.N;
            runnable2 = this.f1416a.P;
            handler4.removeCallbacks(runnable2);
        }
        this.f1416a.Y = i;
        if (i == 0) {
            handler2 = this.f1416a.N;
            if (handler2 != null) {
                handler3 = this.f1416a.N;
                runnable = this.f1416a.P;
                handler3.postDelayed(runnable, 300L);
            }
            bnVar3 = this.f1416a.n;
            onItemLongClickListener = this.f1416a.V;
            bnVar3.a(onItemLongClickListener);
            bnVar4 = this.f1416a.n;
            bnVar4.e(false);
            this.f1416a.K = false;
            return;
        }
        bnVar = this.f1416a.n;
        bnVar.a((AdapterView.OnItemLongClickListener) null);
        bnVar2 = this.f1416a.n;
        bnVar2.e(true);
        this.f1416a.K = true;
    }
}
