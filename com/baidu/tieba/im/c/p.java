package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bDU;
    final /* synthetic */ o bDZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bDZ = oVar;
        this.bDU = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.SX().c(this.bDU.getGroupId(), String.valueOf(this.bDU.getRecordId()), String.valueOf(this.bDU.getMsgId()), 2));
    }
}
