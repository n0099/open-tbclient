package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bmT;
    private final /* synthetic */ OfficialChatMessage bmW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bmT = bVar;
        this.bmW = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.Ql().a(this.bmW.getUserId(), this.bmW.getToUserId(), String.valueOf(this.bmW.getRecordId()), String.valueOf(this.bmW.getMsgId()), 2));
    }
}
