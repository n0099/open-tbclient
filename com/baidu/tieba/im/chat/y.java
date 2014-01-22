package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.u a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(q qVar, com.baidu.tieba.im.message.u uVar) {
        this.b = qVar;
        this.a = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.g(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.e.a().a(this.a);
        com.baidu.adp.lib.g.e.d("SHANG sendMessage to queue");
    }
}
