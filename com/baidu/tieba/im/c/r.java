package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage bnl;
    final /* synthetic */ o bnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.bnp = oVar;
        this.bnl = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.MO().a(this.bnl.getUserId(), this.bnl.getToUserId(), String.valueOf(this.bnl.getRecordId()), String.valueOf(this.bnl.getMsgId()), 2));
    }
}
