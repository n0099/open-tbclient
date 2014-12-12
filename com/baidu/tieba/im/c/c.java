package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bnj;
    private final /* synthetic */ CommonGroupChatMessage bnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bnj = bVar;
        this.bnk = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Mu().b(this.bnk.getGroupId(), String.valueOf(this.bnk.getRecordId()), String.valueOf(this.bnk.getMsgId()), 2));
    }
}
