package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cWC;
    private final /* synthetic */ OfficialChatMessage cWF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.cWC = bVar;
        this.cWF = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.apo().a(this.cWF.getUserId(), this.cWF.getToUserId(), String.valueOf(this.cWF.getRecordId()), String.valueOf(this.cWF.getMsgId()), 2));
    }
}
