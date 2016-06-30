package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cVX;
    private final /* synthetic */ CommonGroupChatMessage cVY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cVX = bVar;
        this.cVY = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.amG().c(this.cVY.getGroupId(), String.valueOf(this.cVY.getRecordId()), String.valueOf(this.cVY.getMsgId()), 2));
    }
}
