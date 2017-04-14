package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ OfficialChatMessage deG;
    final /* synthetic */ o deK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, OfficialChatMessage officialChatMessage) {
        this.deK = oVar;
        this.deG = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        a.h(this.deG);
    }
}
