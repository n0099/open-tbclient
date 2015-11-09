package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ OfficialChatMessage bHE;
    final /* synthetic */ o bHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, OfficialChatMessage officialChatMessage) {
        this.bHI = oVar;
        this.bHE = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bHE);
    }
}
