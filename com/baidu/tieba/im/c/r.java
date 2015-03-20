package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage bmF;
    final /* synthetic */ o bmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.bmJ = oVar;
        this.bmF = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.PZ().a(this.bmF.getUserId(), this.bmF.getToUserId(), String.valueOf(this.bmF.getRecordId()), String.valueOf(this.bmF.getMsgId()), 2));
    }
}
