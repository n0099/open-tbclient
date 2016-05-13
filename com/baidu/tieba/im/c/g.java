package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cqH;
    private final /* synthetic */ OfficialChatMessage cqK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.cqH = bVar;
        this.cqK = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.aeE().a(this.cqK.getUserId(), this.cqK.getToUserId(), String.valueOf(this.cqK.getRecordId()), String.valueOf(this.cqK.getMsgId()), 2));
    }
}
