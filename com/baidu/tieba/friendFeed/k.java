package com.baidu.tieba.friendFeed;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class k implements AbsListView.OnScrollListener {
    final /* synthetic */ FriendFeedActivity aHM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(FriendFeedActivity friendFeedActivity) {
        this.aHM = friendFeedActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        y yVar;
        if (i != 0) {
            yVar = this.aHM.aHt;
            yVar.Ja();
        }
    }
}
