package com.baidu.tieba.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class al implements aj {
    final /* synthetic */ NewFriendsActivity bgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewFriendsActivity newFriendsActivity) {
        this.bgY = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.aj
    public void a(int i, int i2, View view, com.baidu.tieba.im.data.e eVar) {
        if (eVar.getStatus() != 0) {
            if (eVar.getStatus() != 1) {
                return;
            }
            this.bgY.g(eVar);
            return;
        }
        this.bgY.f(eVar);
    }
}
