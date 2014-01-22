package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.bj a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(q qVar, com.baidu.tieba.im.message.bj bjVar) {
        this.b = qVar;
        this.a = bjVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.a != null) {
            this.b.d(this.a);
        }
    }
}
