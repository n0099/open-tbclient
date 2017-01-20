package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ PersonalChatMessage ddQ;
    final /* synthetic */ o ddV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.ddV = oVar;
        this.ddQ = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aqw().a(this.ddQ.getUserId(), this.ddQ.getToUserId(), String.valueOf(this.ddQ.getRecordId()), String.valueOf(this.ddQ.getMsgId()), 2));
    }
}
