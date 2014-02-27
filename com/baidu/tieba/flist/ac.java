package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
final class ac implements AbsListView.OnScrollListener {
    final /* synthetic */ ForumRankActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(ForumRankActivity forumRankActivity) {
        this.a = forumRankActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.a.l;
        runnable = this.a.r;
        handler.removeCallbacks(runnable);
        handler2 = this.a.l;
        runnable2 = this.a.r;
        handler2.postDelayed(runnable2, 300L);
    }
}
