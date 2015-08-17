package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bDn;
    final /* synthetic */ o bDs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bDs = oVar;
        this.bDn = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.SV().c(this.bDn.getGroupId(), String.valueOf(this.bDn.getRecordId()), String.valueOf(this.bDn.getMsgId()), 2));
    }
}
