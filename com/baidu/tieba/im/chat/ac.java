package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class ac extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x aOb;
    private final /* synthetic */ OfficialChatMessage aOe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(x xVar, OfficialChatMessage officialChatMessage) {
        this.aOb = xVar;
        this.aOe = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MT().a(this.aOe.getUserId(), this.aOe.getToUserId(), String.valueOf(this.aOe.getRecordId()), String.valueOf(this.aOe.getMsgId()), 2));
    }
}
