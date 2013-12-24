package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.d a;
    final /* synthetic */ MsglistModel b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(MsglistModel msglistModel, com.baidu.tieba.im.message.d dVar) {
        this.b = msglistModel;
        this.a = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.a((com.baidu.tieba.im.message.b) this.a);
    }
}
