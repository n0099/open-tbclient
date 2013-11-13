package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class ag implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumRankActivity f1242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ForumRankActivity forumRankActivity) {
        this.f1242a = forumRankActivity;
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
        handler = this.f1242a.l;
        runnable = this.f1242a.o;
        handler.removeCallbacks(runnable);
        handler2 = this.f1242a.l;
        runnable2 = this.f1242a.o;
        handler2.postDelayed(runnable2, 300L);
    }
}
