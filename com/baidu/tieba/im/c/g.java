package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.p<Boolean> {
    final /* synthetic */ b cpK;
    private final /* synthetic */ OfficialChatMessage cpN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.cpK = bVar;
        this.cpN = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.aeD().a(this.cpN.getUserId(), this.cpN.getToUserId(), String.valueOf(this.cpN.getRecordId()), String.valueOf(this.cpN.getMsgId()), 2));
    }
}
