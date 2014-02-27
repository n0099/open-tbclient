package com.baidu.tieba.frs;

import android.os.Handler;
import android.widget.AbsListView;
import android.widget.AdapterView;
/* loaded from: classes.dex */
final class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FrsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FrsActivity frsActivity) {
        this.a = frsActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        bs bsVar;
        bs bsVar2;
        Handler handler2;
        bs bsVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        bs bsVar4;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.W;
        if (handler != null) {
            handler4 = this.a.W;
            runnable2 = this.a.Y;
            handler4.removeCallbacks(runnable2);
        }
        this.a.ah = i;
        if (i != 0) {
            bsVar = this.a.p;
            bsVar.a((AdapterView.OnItemLongClickListener) null);
            bsVar2 = this.a.p;
            bsVar2.f(true);
            this.a.N = true;
            return;
        }
        handler2 = this.a.W;
        if (handler2 != null) {
            handler3 = this.a.W;
            runnable = this.a.Y;
            handler3.postDelayed(runnable, 300L);
        }
        bsVar3 = this.a.p;
        onItemLongClickListener = this.a.ae;
        bsVar3.a(onItemLongClickListener);
        bsVar4 = this.a.p;
        bsVar4.f(false);
        this.a.N = false;
    }
}
