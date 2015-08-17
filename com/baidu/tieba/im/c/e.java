package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bDm;
    private final /* synthetic */ PersonalChatMessage bDo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bDm = bVar;
        this.bDo = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.Tk().a(this.bDo.getUserId(), this.bDo.getToUserId(), String.valueOf(this.bDo.getRecordId()), String.valueOf(this.bDo.getMsgId()), 2));
    }
}
