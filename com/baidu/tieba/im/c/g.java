package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ b caG;
    private final /* synthetic */ OfficialChatMessage caJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.caG = bVar;
        this.caJ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Yw().a(this.caJ.getUserId(), this.caJ.getToUserId(), String.valueOf(this.caJ.getRecordId()), String.valueOf(this.caJ.getMsgId()), 2));
    }
}
