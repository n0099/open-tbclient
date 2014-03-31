package com.baidu.tieba.im.chat.receiveChatMsgHandler;
/* loaded from: classes.dex */
final class k implements com.baidu.tieba.im.a<Void> {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Void r1) {
        com.baidu.tieba.im.pushNotify.o.a();
        com.baidu.tieba.im.pushNotify.o.d();
    }
}
