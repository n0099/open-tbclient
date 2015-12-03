package com.baidu.tieba.addresslist.im.newFriend;

import android.view.View;
import com.baidu.tieba.addresslist.im.newFriend.ai;
/* loaded from: classes.dex */
class aj implements ai.b {
    final /* synthetic */ NewFriendsActivity aIX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(NewFriendsActivity newFriendsActivity) {
        this.aIX = newFriendsActivity;
    }

    @Override // com.baidu.tieba.addresslist.im.newFriend.ai.b
    public void a(int i, int i2, View view, com.baidu.tieba.im.data.b bVar) {
        if (bVar.getStatus() != 0) {
            if (bVar.getStatus() != 1) {
                return;
            }
            this.aIX.e(bVar);
            return;
        }
        this.aIX.d(bVar);
    }
}
