package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x a;
    private final /* synthetic */ OfficialChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar, OfficialChatMessage officialChatMessage) {
        this.a = xVar;
        this.b = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        w.a(this.b);
    }
}
