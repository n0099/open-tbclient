package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bmD;
    private final /* synthetic */ OfficialChatMessage bmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bmD = bVar;
        this.bmG = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.PY().a(this.bmG.getUserId(), this.bmG.getToUserId(), String.valueOf(this.bmG.getRecordId()), String.valueOf(this.bmG.getMsgId()), 2));
    }
}
