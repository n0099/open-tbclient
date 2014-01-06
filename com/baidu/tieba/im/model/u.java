package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.s a;
    final /* synthetic */ MsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(MsglistModel msglistModel, com.baidu.tieba.im.message.s sVar) {
        this.b = msglistModel;
        this.a = sVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.a((com.baidu.tieba.im.message.b) this.a);
    }
}
