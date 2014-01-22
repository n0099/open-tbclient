package com.baidu.tieba.im.chat;

import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
class ah implements com.baidu.tieba.im.widget.h {
    final /* synthetic */ ag a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ag agVar) {
        this.a = agVar;
    }

    @Override // com.baidu.tieba.im.widget.h
    public void a() {
        TiebaApplication.h().y(false);
        com.baidu.tieba.im.message.aq aqVar = new com.baidu.tieba.im.message.aq();
        aqVar.a(com.baidu.adp.lib.f.b.a(GroupChatActivity.b, 0));
        com.baidu.tieba.im.messageCenter.e.a().a(aqVar);
    }
}
