package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.w<Boolean> {
    private final /* synthetic */ PersonalChatMessage doq;
    final /* synthetic */ o dov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.dov = oVar;
        this.doq = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.w
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.aso().a(this.doq.getUserId(), this.doq.getToUserId(), String.valueOf(this.doq.getRecordId()), String.valueOf(this.doq.getMsgId()), 2));
    }
}
