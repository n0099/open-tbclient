package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.l<Boolean> {
    final /* synthetic */ b bGV;
    private final /* synthetic */ PersonalChatMessage bGX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bGV = bVar;
        this.bGX = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.l
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.TU().a(this.bGX.getUserId(), this.bGX.getToUserId(), String.valueOf(this.bGX.getRecordId()), String.valueOf(this.bGX.getMsgId()), 2));
    }
}
