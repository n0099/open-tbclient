package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bWI;
    final /* synthetic */ o bWO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bWO = oVar;
        this.bWI = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Xc().c(this.bWI.getGroupId(), String.valueOf(this.bWI.getRecordId()), String.valueOf(this.bWI.getMsgId()), 2));
    }
}
