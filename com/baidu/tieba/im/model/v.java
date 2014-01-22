package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.u a;
    final /* synthetic */ MsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MsglistModel msglistModel, com.baidu.tieba.im.message.u uVar) {
        this.b = msglistModel;
        this.a = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.a((com.baidu.tieba.im.message.b) this.a);
    }
}
