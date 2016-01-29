package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ b cff;
    private final /* synthetic */ CommonGroupChatMessage cfg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cff = bVar;
        this.cfg = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aaT().c(this.cfg.getGroupId(), String.valueOf(this.cfg.getRecordId()), String.valueOf(this.cfg.getMsgId()), 2));
    }
}
