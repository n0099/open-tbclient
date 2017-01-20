package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ OfficialChatMessage ddR;
    final /* synthetic */ o ddV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.ddV = oVar;
        this.ddR = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.aqv().a(this.ddR.getUserId(), this.ddR.getToUserId(), String.valueOf(this.ddR.getRecordId()), String.valueOf(this.ddR.getMsgId()), 2));
    }
}
