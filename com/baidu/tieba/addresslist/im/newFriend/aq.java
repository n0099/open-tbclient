package com.baidu.tieba.addresslist.im.newFriend;

import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class aq implements q.a {
    final /* synthetic */ NewFriendsActivity aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewFriendsActivity newFriendsActivity) {
        this.aIX = newFriendsActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        if (!z) {
            this.aIX.Ho();
        }
    }
}
