package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ OfficialChatMessage bnm;
    final /* synthetic */ o bnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.bnp = oVar;
        this.bnm = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MN().a(this.bnm.getUserId(), this.bnm.getToUserId(), String.valueOf(this.bnm.getRecordId()), String.valueOf(this.bnm.getMsgId()), 2));
    }
}
