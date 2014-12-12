package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bnj;
    private final /* synthetic */ OfficialChatMessage bnm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bnj = bVar;
        this.bnm = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.MN().a(this.bnm.getUserId(), this.bnm.getToUserId(), String.valueOf(this.bnm.getRecordId()), String.valueOf(this.bnm.getMsgId()), 2));
    }
}
