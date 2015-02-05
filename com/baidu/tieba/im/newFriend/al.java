package com.baidu.tieba.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class al implements aj {
    final /* synthetic */ NewFriendsActivity blA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewFriendsActivity newFriendsActivity) {
        this.blA = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.aj
    public void a(int i, int i2, View view, com.baidu.tieba.im.data.b bVar) {
        if (bVar.getStatus() != 0) {
            if (bVar.getStatus() != 1) {
                return;
            }
            this.blA.h(bVar);
            return;
        }
        this.blA.g(bVar);
    }
}
