package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ OfficialChatMessage boI;
    final /* synthetic */ o boL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.boL = oVar;
        this.boI = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.Ne().a(this.boI.getUserId(), this.boI.getToUserId(), String.valueOf(this.boI.getRecordId()), String.valueOf(this.boI.getMsgId()), 2));
    }
}
