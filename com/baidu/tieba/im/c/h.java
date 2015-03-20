package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class h implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ b bmD;
    private final /* synthetic */ OfficialChatMessage bmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, OfficialChatMessage officialChatMessage) {
        this.bmD = bVar;
        this.bmG = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bmG);
    }
}
