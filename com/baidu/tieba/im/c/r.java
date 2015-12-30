package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ PersonalChatMessage caI;
    final /* synthetic */ o caN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.caN = oVar;
        this.caI = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.Yx().a(this.caI.getUserId(), this.caI.getToUserId(), String.valueOf(this.caI.getRecordId()), String.valueOf(this.caI.getMsgId()), 2));
    }
}
