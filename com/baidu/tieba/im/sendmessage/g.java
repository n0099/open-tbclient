package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ b daV;
    private final /* synthetic */ OfficialChatMessage daY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.daV = bVar;
        this.daY = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.anC().a(this.daY.getUserId(), this.daY.getToUserId(), String.valueOf(this.daY.getRecordId()), String.valueOf(this.daY.getMsgId()), 2));
    }
}
