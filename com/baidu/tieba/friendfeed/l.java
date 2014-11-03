package com.baidu.tieba.friendfeed;

import android.widget.AbsListView;
/* loaded from: classes.dex */
class l implements AbsListView.OnScrollListener {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i) {
        y yVar;
        if (i != 0) {
            yVar = this.ayU.ayz;
            yVar.ER();
        }
    }
}
