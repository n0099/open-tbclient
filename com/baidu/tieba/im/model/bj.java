package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class bj extends com.baidu.tieba.im.b<Void> {
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bj(String str) {
        this.b = str;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.b
    /* renamed from: b */
    public Void a() {
        com.baidu.tieba.im.db.h.a().a(com.baidu.tieba.im.db.h.c(this.b), true);
        return null;
    }
}
