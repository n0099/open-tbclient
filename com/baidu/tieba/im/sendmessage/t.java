package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ OfficialChatMessage dgj;
    final /* synthetic */ o dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.dgn = oVar;
        this.dgj = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.apP().a(this.dgj.getUserId(), this.dgj.getToUserId(), String.valueOf(this.dgj.getRecordId()), String.valueOf(this.dgj.getMsgId()), 2));
    }
}
