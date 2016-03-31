package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.p<Boolean> {
    final /* synthetic */ b cpK;
    private final /* synthetic */ CommonGroupChatMessage cpL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cpK = bVar;
        this.cpL = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aep().c(this.cpL.getGroupId(), String.valueOf(this.cpL.getRecordId()), String.valueOf(this.cpL.getMsgId()), 2));
    }
}
