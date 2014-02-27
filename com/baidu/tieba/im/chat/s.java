package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.g c;
    private final /* synthetic */ com.baidu.tieba.im.message.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, com.baidu.tieba.im.message.g gVar, com.baidu.tieba.im.message.b bVar) {
        this.a = qVar;
        this.c = gVar;
        this.d = bVar;
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // com.baidu.tieba.im.b
    public final /* synthetic */ Boolean a() {
        return Boolean.valueOf(com.baidu.tieba.im.db.b.a().b(this.c.u(), String.valueOf(this.d.j()), String.valueOf(this.d.l()), 2));
    }
}
