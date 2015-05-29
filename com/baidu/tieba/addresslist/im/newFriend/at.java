package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class at implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ NewFriendsActivity aAs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.aAs = newFriendsActivity;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.aAs.FT();
        }
    }
}
