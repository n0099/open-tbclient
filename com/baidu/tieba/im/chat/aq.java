package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ OfficialChatMessage aNQ;
    final /* synthetic */ ak aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ak akVar, OfficialChatMessage officialChatMessage) {
        this.aNV = akVar;
        this.aNQ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aNQ);
    }
}
