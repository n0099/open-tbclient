package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage boI;
    final /* synthetic */ o boM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.boM = oVar;
        this.boI = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.o.Nk().a(this.boI.getUserId(), this.boI.getToUserId(), String.valueOf(this.boI.getRecordId()), String.valueOf(this.boI.getMsgId()), 2));
    }
}
