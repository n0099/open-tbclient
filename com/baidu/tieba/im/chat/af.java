package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.g b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(q qVar, com.baidu.tieba.im.message.g gVar) {
        this.a = qVar;
        this.b = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.g(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.e.a().a(this.b);
        com.baidu.adp.lib.util.f.e("SHANG sendMessage to queue");
    }
}
