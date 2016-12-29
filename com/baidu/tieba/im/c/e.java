package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b cWC;
    private final /* synthetic */ PersonalChatMessage cWE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.cWC = bVar;
        this.cWE = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.app().a(this.cWE.getUserId(), this.cWE.getToUserId(), String.valueOf(this.cWE.getRecordId()), String.valueOf(this.cWE.getMsgId()), 2));
    }
}
