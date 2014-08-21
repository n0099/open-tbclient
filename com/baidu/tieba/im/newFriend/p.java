package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ o a;
    private final /* synthetic */ long b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, long j, com.baidu.tieba.im.data.k kVar) {
        this.a = oVar;
        this.b = j;
        this.c = kVar;
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
