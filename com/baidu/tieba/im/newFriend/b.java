package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class b extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ a b;
    private final /* synthetic */ com.baidu.tieba.im.data.k c;
    private final /* synthetic */ long d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, com.baidu.tieba.im.data.k kVar, long j) {
        this.b = aVar;
        this.c = kVar;
        this.d = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (this.c != null && !com.baidu.tieba.im.db.n.a().b(this.d)) {
            com.baidu.tieba.im.db.n.a().a(this.c);
        }
        return null;
    }
}
