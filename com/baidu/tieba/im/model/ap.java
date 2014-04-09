package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class ap extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ an b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.f c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(an anVar, com.baidu.tieba.im.message.a.f fVar) {
        this.b = anVar;
        this.c = fVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.d().a(this.c.x(), this.c.l(), String.valueOf(this.c.u()), String.valueOf(this.c.w()), 2));
    }
}
