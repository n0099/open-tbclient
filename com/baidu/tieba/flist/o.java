package com.baidu.tieba.flist;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class o implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ForumListActivity f1257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(ForumListActivity forumListActivity) {
        this.f1257a = forumListActivity;
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
        handler = this.f1257a.e;
        runnable = this.f1257a.P;
        handler.removeCallbacks(runnable);
        handler2 = this.f1257a.e;
        runnable2 = this.f1257a.P;
        handler2.postDelayed(runnable2, 300L);
    }
}
