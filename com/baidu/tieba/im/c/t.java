package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.p<Boolean> {
    private final /* synthetic */ OfficialChatMessage cpN;
    final /* synthetic */ o cpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.cpR = oVar;
        this.cpN = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.aeD().a(this.cpN.getUserId(), this.cpN.getToUserId(), String.valueOf(this.cpN.getRecordId()), String.valueOf(this.cpN.getMsgId()), 2));
    }
}
