package com.baidu.tieba.addresslist.im.newFriend;
/* loaded from: classes.dex */
class at implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ NewFriendsActivity ayz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.ayz = newFriendsActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.ayz.EU();
        }
    }
}
