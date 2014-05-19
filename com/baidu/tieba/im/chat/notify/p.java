package com.baidu.tieba.im.chat.notify;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements AbsListView.OnScrollListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        BdListView bdListView;
        BdListView bdListView2;
        handler = this.a.g;
        runnable = this.a.h;
        handler.removeCallbacks(runnable);
        handler2 = this.a.g;
        runnable2 = this.a.h;
        handler2.postDelayed(runnable2, 90L);
        bdListView = this.a.k;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.a.k;
            bdListView2.getAdapter().getCount();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
