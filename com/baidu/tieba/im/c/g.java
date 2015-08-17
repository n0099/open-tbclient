package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bDm;
    private final /* synthetic */ OfficialChatMessage bDp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bDm = bVar;
        this.bDp = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Tj().a(this.bDp.getUserId(), this.bDp.getToUserId(), String.valueOf(this.bDp.getRecordId()), String.valueOf(this.bDp.getMsgId()), 2));
    }
}
