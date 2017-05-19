package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.v<Boolean> {
    private final /* synthetic */ PersonalChatMessage daX;
    final /* synthetic */ o dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.dbc = oVar;
        this.daX = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.v
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.anD().a(this.daX.getUserId(), this.daX.getToUserId(), String.valueOf(this.daX.getRecordId()), String.valueOf(this.daX.getMsgId()), 2));
    }
}
