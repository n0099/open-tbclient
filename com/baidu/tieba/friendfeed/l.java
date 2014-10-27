package com.baidu.tieba.friendfeed;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FriendFeedActivity ayL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FriendFeedActivity friendFeedActivity) {
        this.ayL = friendFeedActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        y yVar;
        if (i != 0) {
            yVar = this.ayL.ayq;
            yVar.EP();
        }
    }
}
