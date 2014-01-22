package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.bm a;
    final /* synthetic */ q b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar, com.baidu.tieba.im.message.bm bmVar) {
        this.b = qVar;
        this.a = bmVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        if (this.a != null) {
            this.b.d(this.a);
        }
    }
}
