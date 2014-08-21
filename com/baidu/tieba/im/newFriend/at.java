package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.core.dialog.BdToast;
import java.util.List;
/* loaded from: classes.dex */
class at implements be {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void a(String str) {
        String str2;
        this.a.b();
        com.baidu.tbadk.h a = com.baidu.tbadk.h.a();
        str2 = this.a.c;
        a.b(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.be
    public void b(String str) {
        az azVar;
        az azVar2;
        azVar = this.a.d;
        azVar.b();
        azVar2 = this.a.d;
        azVar2.a((List<com.baidu.tieba.im.data.k>) null);
        BdToast.a(this.a, str);
    }
}
