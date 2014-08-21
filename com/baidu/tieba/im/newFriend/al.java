package com.baidu.tieba.im.newFriend;

import android.view.View;
/* loaded from: classes.dex */
class al implements aj {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.aj
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
