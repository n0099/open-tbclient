package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class k extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ j b;
    private final /* synthetic */ long c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, long j) {
        this.b = jVar;
        this.c = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (0 != this.c) {
            com.baidu.tieba.im.db.n.a().a(this.c);
        }
        return null;
    }
}
