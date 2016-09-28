package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class r extends com.baidu.tbadk.util.t<Boolean> {
    private final /* synthetic */ PersonalChatMessage dma;
    final /* synthetic */ o dmf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar, PersonalChatMessage personalChatMessage) {
        this.dmf = oVar;
        this.dma = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.asT().a(this.dma.getUserId(), this.dma.getToUserId(), String.valueOf(this.dma.getRecordId()), String.valueOf(this.dma.getMsgId()), 2));
    }
}
