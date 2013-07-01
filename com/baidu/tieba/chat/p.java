package com.baidu.tieba.chat;

import android.os.Handler;
import android.widget.AbsListView;
/* loaded from: classes.dex */
class p implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListActivity f733a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ChatListActivity chatListActivity) {
        this.f733a = chatListActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f733a.d;
        runnable = this.f733a.e;
        handler.removeCallbacks(runnable);
        handler2 = this.f733a.d;
        runnable2 = this.f733a.e;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
