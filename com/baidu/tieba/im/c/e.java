package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.p<Boolean> {
    final /* synthetic */ b cpK;
    private final /* synthetic */ PersonalChatMessage cpM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.cpK = bVar;
        this.cpM = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.p
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aeE().a(this.cpM.getUserId(), this.cpM.getToUserId(), String.valueOf(this.cpM.getRecordId()), String.valueOf(this.cpM.getMsgId()), 2));
    }
}
