package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ OfficialChatMessage dmb;
    final /* synthetic */ o dmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.dmf = oVar;
        this.dmb = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.asS().a(this.dmb.getUserId(), this.dmb.getToUserId(), String.valueOf(this.dmb.getRecordId()), String.valueOf(this.dmb.getMsgId()), 2));
    }
}
