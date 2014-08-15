package com.baidu.tieba.im.newFriend;

import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ar implements com.baidu.tieba.im.a<List<com.baidu.tieba.im.data.k>> {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(List<com.baidu.tieba.im.data.k> list) {
        av avVar;
        av avVar2;
        avVar = this.a.d;
        avVar.c().a(list);
        avVar2 = this.a.d;
        avVar2.c().notifyDataSetChanged();
    }
}
