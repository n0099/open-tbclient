package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class ap extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ am b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.e c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(am amVar, com.baidu.tieba.im.message.a.e eVar) {
        this.b = amVar;
        this.c = eVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.d().a(this.c.x(), this.c.l(), String.valueOf(this.c.u()), String.valueOf(this.c.w()), 2));
    }
}
