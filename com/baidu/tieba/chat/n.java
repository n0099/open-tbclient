package com.baidu.tieba.chat;

import android.os.Handler;
import android.widget.AbsListView;
import com.baidu.adp.widget.ListView.BdListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements AbsListView.OnScrollListener {
    final /* synthetic */ ChatListFragment a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(ChatListFragment chatListFragment) {
        this.a = chatListFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        BdListView bdListView;
        BdListView bdListView2;
        handler = this.a.e;
        runnable = this.a.f;
        handler.removeCallbacks(runnable);
        handler2 = this.a.e;
        runnable2 = this.a.f;
        handler2.postDelayed(runnable2, 300L);
        bdListView = this.a.i;
        if (bdListView.getAdapter() != null) {
            bdListView2 = this.a.i;
            if (i2 < bdListView2.getAdapter().getCount()) {
            }
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
