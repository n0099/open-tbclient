package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage dkC;
    final /* synthetic */ o dkI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dkI = oVar;
        this.dkC = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.asf().c(this.dkC.getGroupId(), String.valueOf(this.dkC.getRecordId()), String.valueOf(this.dkC.getMsgId()), 2));
    }
}
