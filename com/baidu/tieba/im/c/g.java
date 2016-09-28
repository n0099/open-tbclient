package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ b dlY;
    private final /* synthetic */ OfficialChatMessage dmb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.dlY = bVar;
        this.dmb = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.asS().a(this.dmb.getUserId(), this.dmb.getToUserId(), String.valueOf(this.dmb.getRecordId()), String.valueOf(this.dmb.getMsgId()), 2));
    }
}
