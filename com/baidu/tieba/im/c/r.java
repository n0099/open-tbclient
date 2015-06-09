package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage bpB;
    final /* synthetic */ o bpF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.bpF = oVar;
        this.bpB = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.RC().a(this.bpB.getUserId(), this.bpB.getToUserId(), String.valueOf(this.bpB.getRecordId()), String.valueOf(this.bpB.getMsgId()), 2));
    }
}
