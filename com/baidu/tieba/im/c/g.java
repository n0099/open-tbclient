package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cVX;
    private final /* synthetic */ OfficialChatMessage cWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.cVX = bVar;
        this.cWa = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.amT().a(this.cWa.getUserId(), this.cWa.getToUserId(), String.valueOf(this.cWa.getRecordId()), String.valueOf(this.cWa.getMsgId()), 2));
    }
}
