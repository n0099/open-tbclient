package com.baidu.tieba.im.chat.notify;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class m implements AbsListView.OnScrollListener {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(b bVar) {
        this.a = bVar;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        BdListView bdListView;
        BdListView bdListView2;
        handler = this.a.f;
        runnable = this.a.g;
        handler.removeCallbacks(runnable);
        handler2 = this.a.f;
        runnable2 = this.a.g;
        handler2.postDelayed(runnable2, 300L);
        bdListView = this.a.j;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.a.j;
            bdListView2.getAdapter().getCount();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
