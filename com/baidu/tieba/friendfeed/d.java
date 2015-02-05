package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ FriendFeedActivity aBS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FriendFeedActivity friendFeedActivity) {
        this.aBS = friendFeedActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (z) {
            return;
        }
        this.aBS.f(false, null);
    }
}
