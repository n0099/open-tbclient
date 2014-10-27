package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x aNN;
    private final /* synthetic */ PersonalChatMessage aNP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, PersonalChatMessage personalChatMessage) {
        this.aNN = xVar;
        this.aNP = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.MQ().a(this.aNP.getUserId(), this.aNP.getToUserId(), String.valueOf(this.aNP.getRecordId()), String.valueOf(this.aNP.getMsgId()), 2));
    }
}
