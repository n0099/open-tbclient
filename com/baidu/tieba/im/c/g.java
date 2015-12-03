package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ b bWH;
    private final /* synthetic */ OfficialChatMessage bWK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bWH = bVar;
        this.bWK = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Xq().a(this.bWK.getUserId(), this.bWK.getToUserId(), String.valueOf(this.bWK.getRecordId()), String.valueOf(this.bWK.getMsgId()), 2));
    }
}
