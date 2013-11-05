package com.baidu.tieba.chat;

import android.os.Handler;
import android.widget.AbsListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements AbsListView.OnScrollListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1086a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(ChatListFragment chatListFragment) {
        this.f1086a = chatListFragment;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        Handler handler;
        Runnable runnable;
        Handler handler2;
        Runnable runnable2;
        handler = this.f1086a.f;
        runnable = this.f1086a.g;
        handler.removeCallbacks(runnable);
        handler2 = this.f1086a.f;
        runnable2 = this.f1086a.g;
        handler2.postDelayed(runnable2, 300L);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
    }
}
