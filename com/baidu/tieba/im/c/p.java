package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage cfg;
    final /* synthetic */ o cfm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cfm = oVar;
        this.cfg = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aaT().c(this.cfg.getGroupId(), String.valueOf(this.cfg.getRecordId()), String.valueOf(this.cfg.getMsgId()), 2));
    }
}
