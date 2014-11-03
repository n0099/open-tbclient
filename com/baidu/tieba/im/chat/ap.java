package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ap extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ OfficialChatMessage aOe;
    final /* synthetic */ ak aOj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar, OfficialChatMessage officialChatMessage) {
        this.aOj = akVar;
        this.aOe = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MT().a(this.aOe.getUserId(), this.aOe.getToUserId(), String.valueOf(this.aOe.getRecordId()), String.valueOf(this.aOe.getMsgId()), 2));
    }
}
