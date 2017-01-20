package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b ddO;
    private final /* synthetic */ CommonGroupChatMessage ddP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.ddO = bVar;
        this.ddP = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aqh().b(this.ddP.getGroupId(), String.valueOf(this.ddP.getRecordId()), String.valueOf(this.ddP.getMsgId()), 2));
    }
}
