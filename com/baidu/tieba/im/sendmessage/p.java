package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage dgV;
    final /* synthetic */ o dhb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dhb = oVar;
        this.dgV = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.aqv().b(this.dgV.getGroupId(), String.valueOf(this.dgV.getRecordId()), String.valueOf(this.dgV.getMsgId()), 2));
    }
}
