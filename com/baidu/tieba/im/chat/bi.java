package com.baidu.tieba.im.chat;
/* loaded from: classes.dex */
final class bi implements com.baidu.tieba.im.widget.h {
    final /* synthetic */ bh a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bh bhVar) {
        this.a = bhVar;
    }

    @Override // com.baidu.tieba.im.widget.h
    public final void a() {
        com.baidu.tieba.im.p.a();
        com.baidu.tieba.im.p.b(false);
        com.baidu.tieba.im.message.at atVar = new com.baidu.tieba.im.message.at();
        atVar.d(com.baidu.adp.lib.f.b.a(GroupChatActivity.b, 0));
        com.baidu.adp.framework.c.a().a(atVar);
    }
}
