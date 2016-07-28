package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ PersonalChatMessage cYU;
    final /* synthetic */ o cYZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.cYZ = oVar;
        this.cYU = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.anF().a(this.cYU.getUserId(), this.cYU.getToUserId(), String.valueOf(this.cYU.getRecordId()), String.valueOf(this.cYU.getMsgId()), 2));
    }
}
