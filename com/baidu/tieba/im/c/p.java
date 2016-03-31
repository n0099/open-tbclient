package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.p<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage cpL;
    final /* synthetic */ o cpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cpR = oVar;
        this.cpL = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aep().c(this.cpL.getGroupId(), String.valueOf(this.cpL.getRecordId()), String.valueOf(this.cpL.getMsgId()), 2));
    }
}
