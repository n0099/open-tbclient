package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class al extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage aNO;
    final /* synthetic */ ak aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(ak akVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.aNV = akVar;
        this.aNO = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Mw().c(this.aNO.getGroupId(), String.valueOf(this.aNO.getRecordId()), String.valueOf(this.aNO.getMsgId()), 2));
    }
}
