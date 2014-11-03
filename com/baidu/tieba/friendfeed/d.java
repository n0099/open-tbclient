package com.baidu.tieba.friendfeed;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements com.baidu.adp.widget.ListView.f {
    final /* synthetic */ FriendFeedActivity ayU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(FriendFeedActivity friendFeedActivity) {
        this.ayU = friendFeedActivity;
    }

    @Override // com.baidu.adp.widget.ListView.f
    public void H(boolean z) {
        if (z) {
            return;
        }
        this.ayU.c(false, (String) null);
    }
}
