package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class n extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ m b;
    private final /* synthetic */ long c;
    private final /* synthetic */ com.baidu.tieba.im.data.k d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar, long j, com.baidu.tieba.im.data.k kVar) {
        this.b = mVar;
        this.c = j;
        this.d = kVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (0 != this.c) {
            com.baidu.tieba.im.db.n.a().b(this.d);
        }
        return null;
    }
}
