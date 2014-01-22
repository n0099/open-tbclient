package com.baidu.tieba.im.model;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ com.baidu.tieba.im.message.u a;
    final /* synthetic */ String b;
    final /* synthetic */ ak c;
    final /* synthetic */ MsglistModel d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MsglistModel msglistModel, com.baidu.tieba.im.message.u uVar, String str, ak akVar) {
        this.d = msglistModel;
        this.a = uVar;
        this.b = str;
        this.c = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.d.a(this.a, this.b, this.c);
    }
}
