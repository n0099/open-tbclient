package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tieba.im.a<List<com.baidu.tieba.im.data.k>> {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(List<com.baidu.tieba.im.data.k> list) {
        ao aoVar;
        ao aoVar2;
        aoVar = this.a.d;
        aoVar.b();
        aoVar2 = this.a.d;
        aoVar2.a(list);
    }
}
