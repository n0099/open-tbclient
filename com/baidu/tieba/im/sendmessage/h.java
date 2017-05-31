package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class h implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ b dgs;
    private final /* synthetic */ OfficialChatMessage dgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(b bVar, OfficialChatMessage officialChatMessage) {
        this.dgs = bVar;
        this.dgv = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.dgv);
    }
}
