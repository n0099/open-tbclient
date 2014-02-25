package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(q qVar, com.baidu.tieba.im.message.w wVar) {
        this.a = qVar;
        this.b = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.g(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
        com.baidu.adp.lib.util.f.e("SHANG sendMessage to queue");
    }
}
