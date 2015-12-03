package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.m<Boolean> {
    private final /* synthetic */ PersonalChatMessage bWJ;
    final /* synthetic */ o bWO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.bWO = oVar;
        this.bWJ = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.m
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.Xr().a(this.bWJ.getUserId(), this.bWJ.getToUserId(), String.valueOf(this.bWJ.getRecordId()), String.valueOf(this.bWJ.getMsgId()), 2));
    }
}
