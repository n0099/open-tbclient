package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class am implements ak {
    final /* synthetic */ NewFriendsActivity ayz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(NewFriendsActivity newFriendsActivity) {
        this.ayz = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.ak
    public void a(int i, int i2, View view, com.baidu.tieba.im.data.b bVar) {
        if (bVar.getStatus() != 0) {
            if (bVar.getStatus() != 1) {
                return;
            }
            this.ayz.e(bVar);
            return;
        }
        this.ayz.d(bVar);
    }
}
