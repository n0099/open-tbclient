package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tieba.im.h<Boolean> {
    private final /* synthetic */ OfficialChatMessage bpB;
    final /* synthetic */ b bpy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.bpy = bVar;
        this.bpB = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.m.RA().a(this.bpB.getUserId(), this.bpB.getToUserId(), String.valueOf(this.bpB.getRecordId()), String.valueOf(this.bpB.getMsgId()), 2));
    }
}
