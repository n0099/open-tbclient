package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b dgU;
    private final /* synthetic */ CommonGroupChatMessage dgV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dgU = bVar;
        this.dgV = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aqv().b(this.dgV.getGroupId(), String.valueOf(this.dgV.getRecordId()), String.valueOf(this.dgV.getMsgId()), 2));
    }
}
