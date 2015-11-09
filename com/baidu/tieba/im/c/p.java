package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bHC;
    final /* synthetic */ o bHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bHI = oVar;
        this.bHC = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.TW().c(this.bHC.getGroupId(), String.valueOf(this.bHC.getRecordId()), String.valueOf(this.bHC.getMsgId()), 2));
    }
}
