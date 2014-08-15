package com.baidu.tieba.im.newFriend;
/* loaded from: classes.dex */
class v extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ s a;
    private final /* synthetic */ long b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(s sVar, long j) {
        this.a = sVar;
        this.b = j;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        if (0 != this.b && com.baidu.tieba.im.db.m.a().b(this.b)) {
            com.baidu.tieba.im.data.k kVar = new com.baidu.tieba.im.data.k();
            kVar.a(this.b);
            kVar.a(2);
            kVar.b(0);
            com.baidu.tieba.im.db.m.a().b(kVar);
        }
        return null;
    }
}
