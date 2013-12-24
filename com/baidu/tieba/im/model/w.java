package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.p a;
    final /* synthetic */ String b;
    final /* synthetic */ ai c;
    final /* synthetic */ MsglistModel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MsglistModel msglistModel, com.baidu.tieba.im.message.p pVar, String str, ai aiVar) {
        this.d = msglistModel;
        this.a = pVar;
        this.b = str;
        this.c = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.d.a(this.a, this.b, this.c);
    }
}
