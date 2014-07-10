package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ p a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(p pVar, com.baidu.tieba.im.a aVar) {
        this.a = pVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.i().b(false, this.b);
    }
}
