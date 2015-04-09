package com.baidu.tieba.friendFeed;

import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ae {
    final /* synthetic */ FriendFeedActivity aHU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FriendFeedActivity friendFeedActivity) {
        this.aHU = friendFeedActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        if (z) {
            return;
        }
        this.aHU.g(false, null);
    }
}
