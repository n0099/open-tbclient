package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cqH;
    private final /* synthetic */ PersonalChatMessage cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.cqH = bVar;
        this.cqJ = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.aeD().a(this.cqJ.getUserId(), this.cqJ.getToUserId(), String.valueOf(this.cqJ.getRecordId()), String.valueOf(this.cqJ.getMsgId()), 2));
    }
}
