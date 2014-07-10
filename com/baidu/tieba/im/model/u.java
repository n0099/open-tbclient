package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class u extends com.baidu.tieba.im.b<Void> {
    final /* synthetic */ p b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(p pVar, boolean z, String str) {
        this.b = pVar;
        this.c = z;
        this.d = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        String str;
        if (this.c) {
            str = com.baidu.tieba.im.db.h.c(this.d);
        } else {
            str = this.d;
        }
        com.baidu.tieba.im.db.h.a().a(str, true);
        return null;
    }
}
