package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.v<Boolean> {
    final /* synthetic */ b dgs;
    private final /* synthetic */ PersonalChatMessage dgu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.dgs = bVar;
        this.dgu = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.aoD().a(this.dgu.getUserId(), this.dgu.getToUserId(), String.valueOf(this.dgu.getRecordId()), String.valueOf(this.dgu.getMsgId()), 2));
    }
}
