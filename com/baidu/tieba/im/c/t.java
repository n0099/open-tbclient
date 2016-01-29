package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ OfficialChatMessage cfi;
    final /* synthetic */ o cfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.cfm = oVar;
        this.cfi = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.abh().a(this.cfi.getUserId(), this.cfi.getToUserId(), String.valueOf(this.cfi.getRecordId()), String.valueOf(this.cfi.getMsgId()), 2));
    }
}
