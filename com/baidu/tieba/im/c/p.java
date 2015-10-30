package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bHh;
    final /* synthetic */ o bHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bHn = oVar;
        this.bHh = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.TB().c(this.bHh.getGroupId(), String.valueOf(this.bHh.getRecordId()), String.valueOf(this.bHh.getMsgId()), 2));
    }
}
