package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ah extends com.baidu.tieba.im.m<Boolean> {
    final /* synthetic */ x b;
    private final /* synthetic */ com.baidu.tieba.im.message.a.f c;
    private final /* synthetic */ com.baidu.tieba.im.message.a.a d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(x xVar, com.baidu.tieba.im.message.a.f fVar, com.baidu.tieba.im.message.a.a aVar) {
        this.b = xVar;
        this.c = fVar;
        this.d = aVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.m
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.d().a(this.c.x(), this.c.l(), String.valueOf(this.d.u()), String.valueOf(this.d.w()), 2));
    }
}
