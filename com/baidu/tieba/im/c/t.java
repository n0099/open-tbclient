package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ OfficialChatMessage bWK;
    final /* synthetic */ o bWO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.bWO = oVar;
        this.bWK = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Xq().a(this.bWK.getUserId(), this.bWK.getToUserId(), String.valueOf(this.bWK.getRecordId()), String.valueOf(this.bWK.getMsgId()), 2));
    }
}
