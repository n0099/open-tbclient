package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ OfficialChatMessage aOe;
    final /* synthetic */ ak aOj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ak akVar, OfficialChatMessage officialChatMessage) {
        this.aOj = akVar;
        this.aOe = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aOe);
    }
}
