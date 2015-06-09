package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class am implements ak {
    final /* synthetic */ NewFriendsActivity aAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewFriendsActivity newFriendsActivity) {
        this.aAt = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.ak
    public void a(int i, int i2, View view, com.baidu.tieba.im.data.b bVar) {
        if (bVar.getStatus() != 0) {
            if (bVar.getStatus() != 1) {
                return;
            }
            this.aAt.e(bVar);
            return;
        }
        this.aAt.d(bVar);
    }
}
