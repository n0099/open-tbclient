package com.baidu.tieba.im.f;
/* loaded from: classes.dex */
class m extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ String b;
    private final /* synthetic */ String c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(this.b, this.c);
        return null;
    }
}
