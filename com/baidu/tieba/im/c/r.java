package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.l<Boolean> {
    private final /* synthetic */ PersonalChatMessage bHi;
    final /* synthetic */ o bHn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.bHn = oVar;
        this.bHi = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.TQ().a(this.bHi.getUserId(), this.bHi.getToUserId(), String.valueOf(this.bHi.getRecordId()), String.valueOf(this.bHi.getMsgId()), 2));
    }
}
