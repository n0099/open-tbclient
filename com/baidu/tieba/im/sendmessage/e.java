package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b deD;
    private final /* synthetic */ PersonalChatMessage deF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.deD = bVar;
        this.deF = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.apJ().a(this.deF.getUserId(), this.deF.getToUserId(), String.valueOf(this.deF.getRecordId()), String.valueOf(this.deF.getMsgId()), 2));
    }
}
