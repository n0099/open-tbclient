package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.w<Boolean> {
    private final /* synthetic */ OfficialChatMessage dor;
    final /* synthetic */ o dov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.dov = oVar;
        this.dor = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.asn().a(this.dor.getUserId(), this.dor.getToUserId(), String.valueOf(this.dor.getRecordId()), String.valueOf(this.dor.getMsgId()), 2));
    }
}
