package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b dgg;
    private final /* synthetic */ CommonGroupChatMessage dgh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dgg = bVar;
        this.dgh = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.apB().b(this.dgh.getGroupId(), String.valueOf(this.dgh.getRecordId()), String.valueOf(this.dgh.getMsgId()), 2));
    }
}
