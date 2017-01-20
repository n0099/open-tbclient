package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b ddO;
    private final /* synthetic */ OfficialChatMessage ddR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.ddO = bVar;
        this.ddR = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.aqv().a(this.ddR.getUserId(), this.ddR.getToUserId(), String.valueOf(this.ddR.getRecordId()), String.valueOf(this.ddR.getMsgId()), 2));
    }
}
