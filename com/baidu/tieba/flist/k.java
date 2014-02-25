package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ ForumListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(ForumListActivity forumListActivity) {
        this.a = forumListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.e;
        runnable = this.a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.a.e;
        runnable2 = this.a.P;
        handler2.postDelayed(runnable2, 300L);
    }
}
