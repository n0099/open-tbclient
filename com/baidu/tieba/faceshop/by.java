package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class by implements AbsListView.OnScrollListener {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar) {
        this.a = bwVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.l;
        if (handler != null) {
            handler4 = this.a.l;
            runnable2 = this.a.o;
            handler4.removeCallbacks(runnable2);
        }
        if (i == 0) {
            handler2 = this.a.l;
            if (handler2 != null) {
                handler3 = this.a.l;
                runnable = this.a.o;
                handler3.postDelayed(runnable, 300L);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
