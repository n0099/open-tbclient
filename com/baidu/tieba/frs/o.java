package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
class o implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        bo boVar;
        bo boVar2;
        Handler handler2;
        bo boVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        bo boVar4;
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
            boVar3 = this.a.n;
            onItemLongClickListener = this.a.V;
            boVar3.a(onItemLongClickListener);
            boVar4 = this.a.n;
            boVar4.e(false);
            this.a.J = false;
            return;
        }
        boVar = this.a.n;
        boVar.a((AdapterView.OnItemLongClickListener) null);
        boVar2 = this.a.n;
        boVar2.e(true);
        this.a.J = true;
    }
}
