package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b drI;
    private final /* synthetic */ OfficialChatMessage drL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.drI = bVar;
        this.drL = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.auP().a(this.drL.getUserId(), this.drL.getToUserId(), String.valueOf(this.drL.getRecordId()), String.valueOf(this.drL.getMsgId()), 2));
    }
}
