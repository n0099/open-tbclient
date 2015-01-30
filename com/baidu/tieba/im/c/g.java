package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b boG;
    private final /* synthetic */ OfficialChatMessage boJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.boG = bVar;
        this.boJ = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.Nj().a(this.boJ.getUserId(), this.boJ.getToUserId(), String.valueOf(this.boJ.getRecordId()), String.valueOf(this.boJ.getMsgId()), 2));
    }
}
