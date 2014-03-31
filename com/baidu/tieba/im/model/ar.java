package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ar implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.a.b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(MsglistModel msglistModel, com.baidu.tieba.im.message.a.b bVar) {
        this.a = msglistModel;
        this.b = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* synthetic */ void a(Boolean bool) {
        this.a.c(this.b);
    }
}
