package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class g extends com.baidu.tbadk.util.t<Boolean> {
    final /* synthetic */ b cYS;
    private final /* synthetic */ OfficialChatMessage cYV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(b bVar, OfficialChatMessage officialChatMessage) {
        this.cYS = bVar;
        this.cYV = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.baidu.tbadk.util.t
    public Boolean doInBackground() {
        return Boolean.valueOf(com.baidu.tieba.im.db.k.anE().a(this.cYV.getUserId(), this.cYV.getToUserId(), String.valueOf(this.cYV.getRecordId()), String.valueOf(this.cYV.getMsgId()), 2));
    }
}
