package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1431a;

    private bd(MsglistActivity msglistActivity) {
        this.f1431a = msglistActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bd(MsglistActivity msglistActivity, at atVar) {
        this(msglistActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.g().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
