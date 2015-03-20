package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bmD;
    private final /* synthetic */ PersonalChatMessage bmF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bmD = bVar;
        this.bmF = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.PZ().a(this.bmF.getUserId(), this.bmF.getToUserId(), String.valueOf(this.bmF.getRecordId()), String.valueOf(this.bmF.getMsgId()), 2));
    }
}
