package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class t extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ s a;
    private final /* synthetic */ long b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar, long j, com.baidu.tieba.im.data.k kVar) {
        this.a = sVar;
        this.b = j;
        this.c = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.data.k c;
        if (0 != this.b && (c = com.baidu.tieba.im.db.m.a().c(this.b)) != null) {
            this.c.c(c.d());
            this.c.a(c.b());
            this.c.b(c.c());
            com.baidu.tieba.im.db.m.a().a(this.c);
        }
        return null;
    }
}
