package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ae implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.a.e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsglistModel msglistModel, com.baidu.tieba.im.message.a.e eVar) {
        this.a = msglistModel;
        this.b = eVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        this.a.c(this.b);
    }
}
