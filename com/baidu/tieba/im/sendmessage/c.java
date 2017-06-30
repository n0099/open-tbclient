package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.w<Boolean> {
    final /* synthetic */ b doo;
    private final /* synthetic */ CommonGroupChatMessage dop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.doo = bVar;
        this.dop = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.arZ().c(this.dop.getGroupId(), String.valueOf(this.dop.getRecordId()), String.valueOf(this.dop.getMsgId()), 2));
    }
}
