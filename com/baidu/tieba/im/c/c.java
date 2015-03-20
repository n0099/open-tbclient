package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bmD;
    private final /* synthetic */ CommonGroupChatMessage bmE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bmD = bVar;
        this.bmE = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.PK().b(this.bmE.getGroupId(), String.valueOf(this.bmE.getRecordId()), String.valueOf(this.bmE.getMsgId()), 2));
    }
}
