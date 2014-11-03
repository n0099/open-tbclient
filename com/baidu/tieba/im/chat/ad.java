package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x aOb;
    private final /* synthetic */ OfficialChatMessage aOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar, OfficialChatMessage officialChatMessage) {
        this.aOb = xVar;
        this.aOe = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aOe);
    }
}
