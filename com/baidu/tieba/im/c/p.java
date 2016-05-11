package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage cqI;
    final /* synthetic */ o cqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cqO = oVar;
        this.cqI = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aep().b(this.cqI.getGroupId(), String.valueOf(this.cqI.getRecordId()), String.valueOf(this.cqI.getMsgId()), 2));
    }
}
