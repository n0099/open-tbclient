package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements com.baidu.tieba.im.a<List<com.baidu.tieba.im.data.k>> {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(List<com.baidu.tieba.im.data.k> list) {
        az azVar;
        azVar = this.a.d;
        azVar.b(list);
    }
}
