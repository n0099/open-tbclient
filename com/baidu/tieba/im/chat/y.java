package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class y extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x aOb;
    private final /* synthetic */ CommonGroupChatMessage aOc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.aOb = xVar;
        this.aOc = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.MA().c(this.aOc.getGroupId(), String.valueOf(this.aOc.getRecordId()), String.valueOf(this.aOc.getMsgId()), 2));
    }
}
