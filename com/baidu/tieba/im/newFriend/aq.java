package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class aq extends com.baidu.tieba.im.b<List<com.baidu.tieba.im.data.k>> {
    final /* synthetic */ NewFriendsActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(NewFriendsActivity newFriendsActivity) {
        this.a = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public List<com.baidu.tieba.im.data.k> a() {
        return com.baidu.tieba.im.db.m.a().d();
    }
}
