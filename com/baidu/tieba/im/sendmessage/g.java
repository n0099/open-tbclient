package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b deD;
    private final /* synthetic */ OfficialChatMessage deG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.deD = bVar;
        this.deG = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.apI().a(this.deG.getUserId(), this.deG.getToUserId(), String.valueOf(this.deG.getRecordId()), String.valueOf(this.deG.getMsgId()), 2));
    }
}
