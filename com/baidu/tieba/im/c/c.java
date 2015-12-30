package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ b caG;
    private final /* synthetic */ CommonGroupChatMessage caH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.caG = bVar;
        this.caH = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Yi().c(this.caH.getGroupId(), String.valueOf(this.caH.getRecordId()), String.valueOf(this.caH.getMsgId()), 2));
    }
}
