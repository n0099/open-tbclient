package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ b dgs;
    private final /* synthetic */ OfficialChatMessage dgv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.dgs = bVar;
        this.dgv = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aoC().a(this.dgv.getUserId(), this.dgv.getToUserId(), String.valueOf(this.dgv.getRecordId()), String.valueOf(this.dgv.getMsgId()), 2));
    }
}
