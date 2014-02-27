package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ah implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(q qVar, com.baidu.tieba.im.message.w wVar) {
        this.a = qVar;
        this.b = wVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        this.b.g(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.d.a().a(this.b);
        com.baidu.adp.lib.util.e.e("SHANG sendMessage to queue");
    }
}
