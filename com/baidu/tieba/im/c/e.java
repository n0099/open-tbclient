package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ b bHB;
    private final /* synthetic */ PersonalChatMessage bHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bHB = bVar;
        this.bHD = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.Ul().a(this.bHD.getUserId(), this.bHD.getToUserId(), String.valueOf(this.bHD.getRecordId()), String.valueOf(this.bHD.getMsgId()), 2));
    }
}
