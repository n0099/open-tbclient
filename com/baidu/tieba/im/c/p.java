package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bnk;
    final /* synthetic */ o bnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bnp = oVar;
        this.bnk = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Mu().b(this.bnk.getGroupId(), String.valueOf(this.bnk.getRecordId()), String.valueOf(this.bnk.getMsgId()), 2));
    }
}
