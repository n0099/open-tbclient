package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class aa extends com.baidu.tieba.im.b<Boolean> {
    final /* synthetic */ x aOb;
    private final /* synthetic */ PersonalChatMessage aOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(x xVar, PersonalChatMessage personalChatMessage) {
        this.aOb = xVar;
        this.aOd = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.b
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.MU().a(this.aOd.getUserId(), this.aOd.getToUserId(), String.valueOf(this.aOd.getRecordId()), String.valueOf(this.aOd.getMsgId()), 2));
    }
}
