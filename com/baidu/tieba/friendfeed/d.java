package com.baidu.tieba.friendfeed;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class d implements AbsListView.OnScrollListener {
    final /* synthetic */ FriendFeedActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FriendFeedActivity friendFeedActivity) {
        this.a = friendFeedActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        t tVar;
        if (i != 0) {
            tVar = this.a.c;
            tVar.a();
        }
    }
}
