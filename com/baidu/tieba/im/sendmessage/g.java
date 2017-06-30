package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.w<Boolean> {
    final /* synthetic */ b doo;
    private final /* synthetic */ OfficialChatMessage dor;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.doo = bVar;
        this.dor = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.asn().a(this.dor.getUserId(), this.dor.getToUserId(), String.valueOf(this.dor.getRecordId()), String.valueOf(this.dor.getMsgId()), 2));
    }
}
