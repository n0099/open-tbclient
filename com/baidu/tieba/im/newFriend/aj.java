package com.baidu.tieba.im.newFriend;

import java.util.List;
/* loaded from: classes.dex */
class aj extends com.baidu.tieba.im.b<List<com.baidu.tieba.im.data.k>> {
    final /* synthetic */ NewFriendsActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(NewFriendsActivity newFriendsActivity) {
        this.b = newFriendsActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public List<com.baidu.tieba.im.data.k> a() {
        com.baidu.tieba.im.db.n.a().c();
        return com.baidu.tieba.im.db.n.a().d();
    }
}
