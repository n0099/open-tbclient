package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class an implements com.baidu.tieba.im.widget.h {
    final /* synthetic */ am a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.a = amVar;
    }

    @Override // com.baidu.tieba.im.widget.h
    public void a() {
        TiebaApplication.g().y(false);
        com.baidu.tieba.im.message.aw awVar = new com.baidu.tieba.im.message.aw();
        awVar.a(com.baidu.adp.lib.f.b.a(GroupChatActivity.b, 0));
        com.baidu.tieba.im.messageCenter.e.a().a(awVar);
    }
}
