package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ b dkB;
    private final /* synthetic */ CommonGroupChatMessage dkC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dkB = bVar;
        this.dkC = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.asf().c(this.dkC.getGroupId(), String.valueOf(this.dkC.getRecordId()), String.valueOf(this.dkC.getMsgId()), 2));
    }
}
