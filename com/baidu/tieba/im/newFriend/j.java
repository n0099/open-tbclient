package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class j extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ i a;
    private final /* synthetic */ long b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar, long j, com.baidu.tieba.im.data.k kVar) {
        this.a = iVar;
        this.b = j;
        this.c = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (!com.baidu.tieba.im.db.m.a().b(this.b)) {
            com.baidu.tieba.im.db.m.a().a(this.c);
            return null;
        }
        return null;
    }
}
