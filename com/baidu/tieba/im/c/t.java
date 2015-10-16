package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ OfficialChatMessage bHj;
    final /* synthetic */ o bHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.bHn = oVar;
        this.bHj = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.TT().a(this.bHj.getUserId(), this.bHj.getToUserId(), String.valueOf(this.bHj.getRecordId()), String.valueOf(this.bHj.getMsgId()), 2));
    }
}
