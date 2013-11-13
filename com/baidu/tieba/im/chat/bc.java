package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1523a;

    private bc(MsglistActivity msglistActivity) {
        this.f1523a = msglistActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(MsglistActivity msglistActivity, as asVar) {
        this(msglistActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
