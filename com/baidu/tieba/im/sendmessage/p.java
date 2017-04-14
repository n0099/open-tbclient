package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage deE;
    final /* synthetic */ o deK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.deK = oVar;
        this.deE = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.apu().b(this.deE.getGroupId(), String.valueOf(this.deE.getRecordId()), String.valueOf(this.deE.getMsgId()), 2));
    }
}
