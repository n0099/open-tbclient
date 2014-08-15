package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* loaded from: classes.dex */
class aq implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ak a;
    private final /* synthetic */ OfficialChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ak akVar, OfficialChatMessage officialChatMessage) {
        this.a = akVar;
        this.b = officialChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        w.a(this.b);
    }
}
