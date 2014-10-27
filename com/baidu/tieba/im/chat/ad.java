package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ad implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x aNN;
    private final /* synthetic */ OfficialChatMessage aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(x xVar, OfficialChatMessage officialChatMessage) {
        this.aNN = xVar;
        this.aNQ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aNQ);
    }
}
