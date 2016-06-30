package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cVX;
    private final /* synthetic */ PersonalChatMessage cVZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.cVX = bVar;
        this.cVZ = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.amU().a(this.cVZ.getUserId(), this.cVZ.getToUserId(), String.valueOf(this.cVZ.getRecordId()), String.valueOf(this.cVZ.getMsgId()), 2));
    }
}
