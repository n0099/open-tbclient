package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.cc a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(a aVar, com.baidu.tieba.im.message.cc ccVar) {
        this.b = aVar;
        this.a = ccVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.d(this.a);
    }
}
