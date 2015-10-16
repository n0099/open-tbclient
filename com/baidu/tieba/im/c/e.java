package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ b bHg;
    private final /* synthetic */ PersonalChatMessage bHi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bHg = bVar;
        this.bHi = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.TU().a(this.bHi.getUserId(), this.bHi.getToUserId(), String.valueOf(this.bHi.getRecordId()), String.valueOf(this.bHi.getMsgId()), 2));
    }
}
