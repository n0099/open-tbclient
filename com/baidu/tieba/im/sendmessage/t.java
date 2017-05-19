package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.v<Boolean> {
    private final /* synthetic */ OfficialChatMessage daY;
    final /* synthetic */ o dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.dbc = oVar;
        this.daY = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.anC().a(this.daY.getUserId(), this.daY.getToUserId(), String.valueOf(this.daY.getRecordId()), String.valueOf(this.daY.getMsgId()), 2));
    }
}
