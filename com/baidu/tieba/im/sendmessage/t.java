package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ OfficialChatMessage dgX;
    final /* synthetic */ o dhb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.dhb = oVar;
        this.dgX = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aqJ().a(this.dgX.getUserId(), this.dgX.getToUserId(), String.valueOf(this.dgX.getRecordId()), String.valueOf(this.dgX.getMsgId()), 2));
    }
}
