package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bGW;
    final /* synthetic */ o bHc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bHc = oVar;
        this.bGW = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.TF().c(this.bGW.getGroupId(), String.valueOf(this.bGW.getRecordId()), String.valueOf(this.bGW.getMsgId()), 2));
    }
}
