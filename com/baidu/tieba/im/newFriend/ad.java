package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ad extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ NewFriendsActivity b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.k kVar) {
        this.b = newFriendsActivity;
        this.c = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.a().a(this.c.a()));
    }
}
