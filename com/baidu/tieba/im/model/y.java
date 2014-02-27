package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class y extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ com.baidu.tieba.im.message.w c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar, com.baidu.tieba.im.message.w wVar2) {
        this.a = wVar;
        this.c = wVar2;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.q.a().a(this.c.m(), this.c.c(), String.valueOf(this.c.j()), String.valueOf(this.c.l()), 2));
    }
}
