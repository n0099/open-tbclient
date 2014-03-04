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
        Handler handler2;
        bs bsVar;
        bs bsVar2;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        bs bsVar3;
        AdapterView.OnItemLongClickListener onItemLongClickListener;
        bs bsVar4;
        Handler handler5;
        Runnable runnable2;
        Handler handler6;
        Runnable runnable3;
        handler = this.a.W;
        if (handler != null) {
            handler6 = this.a.W;
            runnable3 = this.a.Y;
            handler6.removeCallbacks(runnable3);
        }
        this.a.ah = i;
        if (i == 0) {
            handler4 = this.a.W;
            if (handler4 != null) {
                handler5 = this.a.W;
                runnable2 = this.a.Y;
                handler5.postDelayed(runnable2, 300L);
            }
            bsVar3 = this.a.p;
            onItemLongClickListener = this.a.ae;
            bsVar3.a(onItemLongClickListener);
            bsVar4 = this.a.p;
            bsVar4.f(false);
            this.a.N = false;
            return;
        }
        handler2 = this.a.W;
        if (handler2 != null && i == 1) {
            handler3 = this.a.W;
            runnable = this.a.Y;
            handler3.postDelayed(runnable, 300L);
        }
        bsVar = this.a.p;
        bsVar.a((AdapterView.OnItemLongClickListener) null);
        bsVar2 = this.a.p;
        bsVar2.f(true);
        this.a.N = true;
    }
}
