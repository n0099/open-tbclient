package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class r implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(p pVar, com.baidu.tieba.im.a aVar) {
        this.a = pVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.d().b(false, this.b);
    }
}
