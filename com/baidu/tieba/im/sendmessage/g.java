package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b dgU;
    private final /* synthetic */ OfficialChatMessage dgX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.dgU = bVar;
        this.dgX = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aqJ().a(this.dgX.getUserId(), this.dgX.getToUserId(), String.valueOf(this.dgX.getRecordId()), String.valueOf(this.dgX.getMsgId()), 2));
    }
}
