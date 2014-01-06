package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class i implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.s a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(a aVar, com.baidu.tieba.im.message.s sVar) {
        this.b = aVar;
        this.a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.f(System.currentTimeMillis());
        com.baidu.tieba.im.messageCenter.e.a().a(this.a);
        com.baidu.adp.lib.h.e.d("SHANG sendMessage to queue");
    }
}
