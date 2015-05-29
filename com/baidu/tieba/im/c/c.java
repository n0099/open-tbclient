package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class c extends com.baidu.tieba.im.h<Boolean> {
    final /* synthetic */ b bpy;
    private final /* synthetic */ CommonGroupChatMessage bpz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bpy = bVar;
        this.bpz = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tieba.im.h
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.c.Rm().b(this.bpz.getGroupId(), String.valueOf(this.bpz.getRecordId()), String.valueOf(this.bpz.getMsgId()), 2));
    }
}
