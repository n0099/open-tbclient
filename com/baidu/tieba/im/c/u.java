package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class u implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ OfficialChatMessage caJ;
    final /* synthetic */ o caN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(o oVar, OfficialChatMessage officialChatMessage) {
        this.caN = oVar;
        this.caJ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.caJ);
    }
}
