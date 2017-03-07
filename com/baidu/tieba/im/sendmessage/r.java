package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.s<Boolean> {
    private final /* synthetic */ PersonalChatMessage dgi;
    final /* synthetic */ o dgn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.dgn = oVar;
        this.dgi = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.apQ().a(this.dgi.getUserId(), this.dgi.getToUserId(), String.valueOf(this.dgi.getRecordId()), String.valueOf(this.dgi.getMsgId()), 2));
    }
}
