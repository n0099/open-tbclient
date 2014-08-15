package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class l extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ k a;
    private final /* synthetic */ long b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar, long j, com.baidu.tieba.im.data.k kVar2) {
        this.a = kVar;
        this.b = j;
        this.c = kVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.data.k c = com.baidu.tieba.im.db.m.a().c(this.b);
        if (c != null) {
            this.c.a(c.b());
            this.c.b(c.c());
            com.baidu.tieba.im.db.m.a().a(this.c);
        }
        return null;
    }
}
