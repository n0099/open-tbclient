package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ b cYS;
    private final /* synthetic */ CommonGroupChatMessage cYT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cYS = bVar;
        this.cYT = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.anq().c(this.cYT.getGroupId(), String.valueOf(this.cYT.getRecordId()), String.valueOf(this.cYT.getMsgId()), 2));
    }
}
