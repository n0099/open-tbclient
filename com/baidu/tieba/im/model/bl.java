package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
class bl implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(String str, com.baidu.tieba.im.a aVar) {
        this.a = str;
        this.b = aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.f().c(this.a);
        com.baidu.tieba.im.pushNotify.a.f().b(false, this.b);
    }
}
