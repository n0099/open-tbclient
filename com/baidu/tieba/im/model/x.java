package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class x extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ com.baidu.tieba.im.message.g c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(w wVar, com.baidu.tieba.im.message.g gVar) {
        this.a = wVar;
        this.c = gVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().b(this.c.u(), String.valueOf(this.c.j()), String.valueOf(this.c.l()), 2));
    }
}
