package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.w<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage dop;
    final /* synthetic */ o dov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dov = oVar;
        this.dop = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.arZ().c(this.dop.getGroupId(), String.valueOf(this.dop.getRecordId()), String.valueOf(this.dop.getMsgId()), 2));
    }
}
