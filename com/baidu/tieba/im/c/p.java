package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage cVY;
    final /* synthetic */ o cWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cWe = oVar;
        this.cVY = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.amG().c(this.cVY.getGroupId(), String.valueOf(this.cVY.getRecordId()), String.valueOf(this.cVY.getMsgId()), 2));
    }
}
