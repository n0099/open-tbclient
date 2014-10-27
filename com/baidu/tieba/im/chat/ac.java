package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ac extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x aNN;
    private final /* synthetic */ OfficialChatMessage aNQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar, OfficialChatMessage officialChatMessage) {
        this.aNN = xVar;
        this.aNQ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MP().a(this.aNQ.getUserId(), this.aNQ.getToUserId(), String.valueOf(this.aNQ.getRecordId()), String.valueOf(this.aNQ.getMsgId()), 2));
    }
}
