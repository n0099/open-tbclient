package com.baidu.tieba.im.newFriend;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ NewFriendDbManagerStatic a;
    private final /* synthetic */ long b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(NewFriendDbManagerStatic newFriendDbManagerStatic, long j, com.baidu.tieba.im.data.k kVar) {
        this.a = newFriendDbManagerStatic;
        this.b = j;
        this.c = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.data.k c = com.baidu.tieba.im.db.m.a().c(this.b);
        if (c != null) {
            this.c.a(c.e());
        }
        com.baidu.tieba.im.db.m.a().a(this.c);
        return null;
    }
}
