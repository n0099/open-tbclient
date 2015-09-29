package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ OfficialChatMessage bGY;
    final /* synthetic */ o bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.bHc = oVar;
        this.bGY = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.TT().a(this.bGY.getUserId(), this.bGY.getToUserId(), String.valueOf(this.bGY.getRecordId()), String.valueOf(this.bGY.getMsgId()), 2));
    }
}
