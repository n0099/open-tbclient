package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ q a;
    private final /* synthetic */ com.baidu.tieba.im.message.bp b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(q qVar, com.baidu.tieba.im.message.bp bpVar) {
        this.a = qVar;
        this.b = bpVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.b != null) {
            this.a.a((com.baidu.tieba.im.message.s) this.b);
        }
    }
}
