package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class ao extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ NewFriendsActivity a;
    private final /* synthetic */ com.baidu.tieba.im.data.k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(NewFriendsActivity newFriendsActivity, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendsActivity;
        this.b = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.a().a(this.b.a()));
    }
}
