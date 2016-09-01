package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ b dkB;
    private final /* synthetic */ OfficialChatMessage dkE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.dkB = bVar;
        this.dkE = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.ast().a(this.dkE.getUserId(), this.dkE.getToUserId(), String.valueOf(this.dkE.getRecordId()), String.valueOf(this.dkE.getMsgId()), 2));
    }
}
