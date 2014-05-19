package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class t implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ r a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(r rVar, com.baidu.tieba.im.a aVar) {
        this.a = rVar;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.f().b(false, this.b);
    }
}
