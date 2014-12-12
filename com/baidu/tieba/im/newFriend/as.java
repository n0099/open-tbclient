package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class as implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ NewFriendsActivity bke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(NewFriendsActivity newFriendsActivity) {
        this.bke = newFriendsActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.bke.RE();
        }
    }
}
