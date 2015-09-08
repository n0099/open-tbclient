package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bDT;
    private final /* synthetic */ OfficialChatMessage bDW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bDT = bVar;
        this.bDW = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Tl().a(this.bDW.getUserId(), this.bDW.getToUserId(), String.valueOf(this.bDW.getRecordId()), String.valueOf(this.bDW.getMsgId()), 2));
    }
}
