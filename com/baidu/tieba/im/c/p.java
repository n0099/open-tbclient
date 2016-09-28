package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class p extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage dlZ;
    final /* synthetic */ o dmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dmf = oVar;
        this.dlZ = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.asE().c(this.dlZ.getGroupId(), String.valueOf(this.dlZ.getRecordId()), String.valueOf(this.dlZ.getMsgId()), 2));
    }
}
