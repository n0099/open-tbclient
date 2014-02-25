package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.w b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(MsglistModel msglistModel, com.baidu.tieba.im.message.w wVar) {
        this.a = msglistModel;
        this.b = wVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a((com.baidu.tieba.im.message.b) this.b);
    }
}
