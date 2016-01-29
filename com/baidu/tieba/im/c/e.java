package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.m<Boolean> {
    final /* synthetic */ b cff;
    private final /* synthetic */ PersonalChatMessage cfh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.cff = bVar;
        this.cfh = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.abi().a(this.cfh.getUserId(), this.cfh.getToUserId(), String.valueOf(this.cfh.getRecordId()), String.valueOf(this.cfh.getMsgId()), 2));
    }
}
