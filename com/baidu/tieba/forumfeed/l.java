package com.baidu.tieba.forumfeed;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l implements AbsListView.OnScrollListener {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar) {
        this.a = jVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.h;
        if (handler != null) {
            handler4 = this.a.h;
            runnable2 = this.a.p;
            handler4.removeCallbacks(runnable2);
        }
        if (i == 0) {
            handler2 = this.a.h;
            if (handler2 != null) {
                handler3 = this.a.h;
                runnable = this.a.p;
                handler3.postDelayed(runnable, 300L);
            }
        }
    }
}
