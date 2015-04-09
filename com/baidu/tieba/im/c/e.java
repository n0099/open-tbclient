package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bmT;
    private final /* synthetic */ PersonalChatMessage bmV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bmT = bVar;
        this.bmV = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.Qm().a(this.bmV.getUserId(), this.bmV.getToUserId(), String.valueOf(this.bmV.getRecordId()), String.valueOf(this.bmV.getMsgId()), 2));
    }
}
