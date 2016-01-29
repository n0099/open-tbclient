package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ b cff;
    private final /* synthetic */ OfficialChatMessage cfi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, OfficialChatMessage officialChatMessage) {
        this.cff = bVar;
        this.cfi = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.cfi);
    }
}
