package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.v<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage dgt;
    final /* synthetic */ o dgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dgz = oVar;
        this.dgt = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aoo().b(this.dgt.getGroupId(), String.valueOf(this.dgt.getRecordId()), String.valueOf(this.dgt.getMsgId()), 2));
    }
}
