package com.baidu.tieba.chat;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.tieba.im.a<Void> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ChatListFragment f1141a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ChatListFragment chatListFragment) {
        this.f1141a = chatListFragment;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Void r3) {
        m mVar;
        m mVar2;
        com.baidu.tieba.model.f fVar;
        mVar = this.f1141a.aa;
        if (mVar != null) {
            mVar2 = this.f1141a.aa;
            fVar = this.f1141a.c;
            mVar2.a(fVar.a());
        }
    }
}
