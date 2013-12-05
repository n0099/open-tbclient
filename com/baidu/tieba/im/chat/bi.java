package com.baidu.tieba.im.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MsglistActivity f1567a;

    private bi(MsglistActivity msglistActivity) {
        this.f1567a = msglistActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bi(MsglistActivity msglistActivity, aw awVar) {
        this(msglistActivity);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r4) {
        com.baidu.tieba.im.pushNotify.a.h().b(false, (com.baidu.tieba.im.a<Void>) null);
    }
}
