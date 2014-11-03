package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class an extends com.baidu.tieba.im.b<Boolean> {
    private final /* synthetic */ PersonalChatMessage aOd;
    final /* synthetic */ ak aOj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar, PersonalChatMessage personalChatMessage) {
        this.aOj = akVar;
        this.aOd = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.MU().a(this.aOd.getUserId(), this.aOd.getToUserId(), String.valueOf(this.aOd.getRecordId()), String.valueOf(this.aOd.getMsgId()), 2));
    }
}
