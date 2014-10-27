package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class an extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ PersonalChatMessage aNP;
    final /* synthetic */ ak aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar, PersonalChatMessage personalChatMessage) {
        this.aNV = akVar;
        this.aNP = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.MQ().a(this.aNP.getUserId(), this.aNP.getToUserId(), String.valueOf(this.aNP.getRecordId()), String.valueOf(this.aNP.getMsgId()), 2));
    }
}
