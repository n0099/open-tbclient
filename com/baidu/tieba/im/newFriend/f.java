package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class f extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ e b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, com.baidu.tieba.im.data.k kVar) {
        this.b = eVar;
        this.c = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.n.a().b(this.c);
        return null;
    }
}
