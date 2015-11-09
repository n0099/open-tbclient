package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ b bHB;
    private final /* synthetic */ OfficialChatMessage bHE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bHB = bVar;
        this.bHE = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Uk().a(this.bHE.getUserId(), this.bHE.getToUserId(), String.valueOf(this.bHE.getRecordId()), String.valueOf(this.bHE.getMsgId()), 2));
    }
}
