package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class u implements com.baidu.tieba.im.g<Boolean> {
    private final /* synthetic */ OfficialChatMessage bpB;
    final /* synthetic */ o bpE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, OfficialChatMessage officialChatMessage) {
        this.bpE = oVar;
        this.bpB = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bpB);
    }
}
