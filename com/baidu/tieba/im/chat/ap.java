package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ap extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ OfficialChatMessage aNQ;
    final /* synthetic */ ak aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar, OfficialChatMessage officialChatMessage) {
        this.aNV = akVar;
        this.aNQ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MP().a(this.aNQ.getUserId(), this.aNQ.getToUserId(), String.valueOf(this.aNQ.getRecordId()), String.valueOf(this.aNQ.getMsgId()), 2));
    }
}
