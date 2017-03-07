package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b dgg;
    private final /* synthetic */ OfficialChatMessage dgj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.dgg = bVar;
        this.dgj = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.apP().a(this.dgj.getUserId(), this.dgj.getToUserId(), String.valueOf(this.dgj.getRecordId()), String.valueOf(this.dgj.getMsgId()), 2));
    }
}
