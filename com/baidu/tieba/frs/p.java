package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(FrsActivity frsActivity) {
        this.a = frsActivity;
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
        handler = this.a.N;
        if (handler != null) {
            handler4 = this.a.N;
            runnable2 = this.a.P;
            handler4.removeCallbacks(runnable2);
        }
        this.a.Y = i;
        if (i == 0) {
            handler2 = this.a.N;
            if (handler2 != null) {
                handler3 = this.a.N;
                runnable = this.a.P;
                handler3.postDelayed(runnable, 300L);
            }
            bnVar3 = this.a.n;
            onItemLongClickListener = this.a.V;
            bnVar3.a(onItemLongClickListener);
            bnVar4 = this.a.n;
            bnVar4.e(false);
            this.a.K = false;
            return;
        }
        bnVar = this.a.n;
        bnVar.a((AdapterView.OnItemLongClickListener) null);
        bnVar2 = this.a.n;
        bnVar2.e(true);
        this.a.K = true;
    }
}
