package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.da b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, com.baidu.tieba.im.message.da daVar) {
        this.a = qVar;
        this.b = daVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a((com.baidu.tieba.im.message.s) this.b);
    }
}
