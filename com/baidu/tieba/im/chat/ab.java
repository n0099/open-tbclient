package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.cr a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(q qVar, com.baidu.tieba.im.message.cr crVar) {
        this.b = qVar;
        this.a = crVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.d(this.a);
    }
}
