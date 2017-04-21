package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b dgU;
    private final /* synthetic */ PersonalChatMessage dgW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.dgU = bVar;
        this.dgW = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.aqK().a(this.dgW.getUserId(), this.dgW.getToUserId(), String.valueOf(this.dgW.getRecordId()), String.valueOf(this.dgW.getMsgId()), 2));
    }
}
