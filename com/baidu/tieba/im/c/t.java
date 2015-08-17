package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ OfficialChatMessage bDp;
    final /* synthetic */ o bDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.bDs = oVar;
        this.bDp = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Tj().a(this.bDp.getUserId(), this.bDp.getToUserId(), String.valueOf(this.bDp.getRecordId()), String.valueOf(this.bDp.getMsgId()), 2));
    }
}
