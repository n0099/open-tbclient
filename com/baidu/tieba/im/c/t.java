package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class t extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ OfficialChatMessage bmG;
    final /* synthetic */ o bmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar, OfficialChatMessage officialChatMessage) {
        this.bmJ = oVar;
        this.bmG = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.PY().a(this.bmG.getUserId(), this.bmG.getToUserId(), String.valueOf(this.bmG.getRecordId()), String.valueOf(this.bmG.getMsgId()), 2));
    }
}
