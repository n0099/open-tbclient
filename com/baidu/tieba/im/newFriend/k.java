package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic a;
    private final /* synthetic */ com.baidu.tieba.im.data.k b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(NewFriendDbManagerStatic newFriendDbManagerStatic, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendDbManagerStatic;
        this.b = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.m.a().a(this.b);
        return null;
    }
}
