package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ b bHg;
    private final /* synthetic */ OfficialChatMessage bHj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bHg = bVar;
        this.bHj = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.TP().a(this.bHj.getUserId(), this.bHj.getToUserId(), String.valueOf(this.bHj.getRecordId()), String.valueOf(this.bHj.getMsgId()), 2));
    }
}
