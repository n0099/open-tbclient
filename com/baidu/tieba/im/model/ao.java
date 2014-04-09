package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class ao extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ an b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar, com.baidu.tieba.im.message.a.b bVar) {
        this.b = anVar;
        this.c = bVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.a().b(this.c.i(), String.valueOf(this.c.u()), String.valueOf(this.c.w()), 2));
    }
}
