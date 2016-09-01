package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ b dkB;
    private final /* synthetic */ PersonalChatMessage dkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.dkB = bVar;
        this.dkD = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.asu().a(this.dkD.getUserId(), this.dkD.getToUserId(), String.valueOf(this.dkD.getRecordId()), String.valueOf(this.dkD.getMsgId()), 2));
    }
}
