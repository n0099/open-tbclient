package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ b bWH;
    private final /* synthetic */ CommonGroupChatMessage bWI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bWH = bVar;
        this.bWI = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Xc().c(this.bWI.getGroupId(), String.valueOf(this.bWI.getRecordId()), String.valueOf(this.bWI.getMsgId()), 2));
    }
}
