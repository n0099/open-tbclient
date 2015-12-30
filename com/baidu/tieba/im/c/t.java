package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ OfficialChatMessage caJ;
    final /* synthetic */ o caN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.caN = oVar;
        this.caJ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.Yw().a(this.caJ.getUserId(), this.caJ.getToUserId(), String.valueOf(this.caJ.getRecordId()), String.valueOf(this.caJ.getMsgId()), 2));
    }
}
