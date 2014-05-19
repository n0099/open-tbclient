package com.baidu.tieba.faceshop;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements AbsListView.OnScrollListener {
    final /* synthetic */ bg a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bg bgVar) {
        this.a = bgVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Runnable runnable;
        Handler handler4;
        Runnable runnable2;
        handler = this.a.j;
        if (handler != null) {
            handler4 = this.a.j;
            runnable2 = this.a.l;
            handler4.removeCallbacks(runnable2);
        }
        if (i == 0) {
            handler2 = this.a.j;
            if (handler2 != null) {
                handler3 = this.a.j;
                runnable = this.a.l;
                handler3.postDelayed(runnable, 90L);
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
