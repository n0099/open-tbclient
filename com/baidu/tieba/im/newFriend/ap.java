package com.baidu.tieba.im.newFriend;

import com.baidu.tbadk.core.dialog.BdToast;
import java.util.List;
/* loaded from: classes.dex */
class ap implements ba {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    @Override // com.baidu.tieba.im.newFriend.ba
    public void a(String str) {
        String str2;
        this.a.b();
        com.baidu.tbadk.h a = com.baidu.tbadk.h.a();
        str2 = this.a.c;
        a.b(str2, true);
    }

    @Override // com.baidu.tieba.im.newFriend.ba
    public void b(String str) {
        av avVar;
        av avVar2;
        avVar = this.a.d;
        avVar.b();
        avVar2 = this.a.d;
        avVar2.a((List<com.baidu.tieba.im.data.k>) null);
        BdToast.a(this.a, str);
    }
}
