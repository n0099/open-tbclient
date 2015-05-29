package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class e extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage bpA;
    final /* synthetic */ b bpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, PersonalChatMessage personalChatMessage) {
        this.bpy = bVar;
        this.bpA = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.n.RB().a(this.bpA.getUserId(), this.bpA.getToUserId(), String.valueOf(this.bpA.getRecordId()), String.valueOf(this.bpA.getMsgId()), 2));
    }
}
