package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.p<Boolean> {
    private final /* synthetic */ PersonalChatMessage cpM;
    final /* synthetic */ o cpR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.cpR = oVar;
        this.cpM = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aeE().a(this.cpM.getUserId(), this.cpM.getToUserId(), String.valueOf(this.cpM.getRecordId()), String.valueOf(this.cpM.getMsgId()), 2));
    }
}
