package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ OfficialChatMessage dkE;
    final /* synthetic */ o dkI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.dkI = oVar;
        this.dkE = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.ast().a(this.dkE.getUserId(), this.dkE.getToUserId(), String.valueOf(this.dkE.getRecordId()), String.valueOf(this.dkE.getMsgId()), 2));
    }
}
