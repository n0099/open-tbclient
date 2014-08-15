package com.baidu.tieba.im.messageCenter;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.b<Integer> {
    final /* synthetic */ d a;
    private final /* synthetic */ boolean b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, boolean z) {
        this.a = dVar;
        this.b = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Integer a() {
        if (!this.b) {
            com.baidu.tieba.im.db.b.a().b();
        }
        return 0;
    }
}
