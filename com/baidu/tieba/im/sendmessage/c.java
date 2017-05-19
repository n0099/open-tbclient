package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ b daV;
    private final /* synthetic */ CommonGroupChatMessage daW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.daV = bVar;
        this.daW = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.ano().b(this.daW.getGroupId(), String.valueOf(this.daW.getRecordId()), String.valueOf(this.daW.getMsgId()), 2));
    }
}
