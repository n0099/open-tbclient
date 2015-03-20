package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bmE;
    final /* synthetic */ o bmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bmJ = oVar;
        this.bmE = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.PK().b(this.bmE.getGroupId(), String.valueOf(this.bmE.getRecordId()), String.valueOf(this.bmE.getMsgId()), 2));
    }
}
