package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ b cpK;
    private final /* synthetic */ OfficialChatMessage cpN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, OfficialChatMessage officialChatMessage) {
        this.cpK = bVar;
        this.cpN = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.cpN);
    }
}
