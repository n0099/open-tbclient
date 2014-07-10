package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class h extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ e b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar, long j) {
        this.b = eVar;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (0 != this.c && com.baidu.tieba.im.db.n.a().b(this.c)) {
            com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
            kVar.a(this.c);
            kVar.a(3);
            kVar.b(0);
            com.baidu.tieba.im.db.n.a().b(kVar);
        }
        return null;
    }
}
