package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tbadk.util.s<Boolean> {
    final /* synthetic */ b dgg;
    private final /* synthetic */ PersonalChatMessage dgi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.dgg = bVar;
        this.dgi = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.s
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.l.apQ().a(this.dgi.getUserId(), this.dgi.getToUserId(), String.valueOf(this.dgi.getRecordId()), String.valueOf(this.dgi.getMsgId()), 2));
    }
}
