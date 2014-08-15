package com.baidu.tieba.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class ah implements af {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.af
    public void a(int i, int i2, View view, com.baidu.tieba.im.data.k kVar) {
        if (kVar.e() != 0) {
            if (kVar.e() != 1) {
                return;
            }
            this.a.b(kVar);
            return;
        }
        this.a.a(kVar);
    }
}
