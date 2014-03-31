package com.baidu.tieba.im.model;
/* loaded from: classes.dex */
final class be implements com.baidu.tieba.im.a<Void> {
    private final /* synthetic */ String a;
    private final /* synthetic */ com.baidu.tieba.im.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(String str, com.baidu.tieba.im.a aVar) {
        this.a = str;
        this.b = aVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.d().b(this.a);
        com.baidu.tieba.im.pushNotify.a.d().b(false, this.b);
    }
}
