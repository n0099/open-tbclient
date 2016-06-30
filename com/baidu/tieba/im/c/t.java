package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ OfficialChatMessage cWa;
    final /* synthetic */ o cWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.cWe = oVar;
        this.cWa = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.amT().a(this.cWa.getUserId(), this.cWa.getToUserId(), String.valueOf(this.cWa.getRecordId()), String.valueOf(this.cWa.getMsgId()), 2));
    }
}
