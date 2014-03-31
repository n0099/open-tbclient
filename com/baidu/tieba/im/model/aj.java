package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class aj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.a.e b;
    private final /* synthetic */ String c;
    private final /* synthetic */ com.baidu.tbadk.img.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(MsglistModel msglistModel, com.baidu.tieba.im.message.a.e eVar, String str, com.baidu.tbadk.img.b bVar) {
        this.a = msglistModel;
        this.b = eVar;
        this.c = str;
        this.d = bVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.baidu.tieba.im.a
    public final /* bridge */ /* synthetic */ void a(Boolean bool) {
        this.a.a(this.b, this.c, this.d);
    }
}
