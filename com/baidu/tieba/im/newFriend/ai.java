package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.core.dialog.BdToast;
import java.util.List;
/* loaded from: classes.dex */
class ai implements at {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.at
    public void a(String str) {
        String str2;
        this.a.a();
        com.baidu.tbadk.i a = com.baidu.tbadk.i.a();
        str2 = this.a.c;
        a.c(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.at
    public void b(String str) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.a.d;
        aoVar.b();
        aoVar2 = this.a.d;
        aoVar2.a((List<com.baidu.tieba.im.data.k>) null);
        BdToast.a(this.a, str);
    }
}
