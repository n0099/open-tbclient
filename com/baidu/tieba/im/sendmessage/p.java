package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.v<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage daW;
    final /* synthetic */ o dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dbc = oVar;
        this.daW = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.ano().b(this.daW.getGroupId(), String.valueOf(this.daW.getRecordId()), String.valueOf(this.daW.getMsgId()), 2));
    }
}
