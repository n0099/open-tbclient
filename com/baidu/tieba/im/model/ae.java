package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ MsglistModel a;
    private final /* synthetic */ com.baidu.tieba.im.message.g b;
    private final /* synthetic */ String c;
    private final /* synthetic */ com.baidu.tieba.img.b d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(MsglistModel msglistModel, com.baidu.tieba.im.message.g gVar, String str, com.baidu.tieba.img.b bVar) {
        this.a = msglistModel;
        this.b = gVar;
        this.c = str;
        this.d = bVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.a.a(this.b, this.c, this.d);
    }
}
