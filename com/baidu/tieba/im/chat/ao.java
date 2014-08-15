package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ak a;
    private final /* synthetic */ PersonalChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar, PersonalChatMessage personalChatMessage) {
        this.a = akVar;
        this.b = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        w.a(this.b);
    }
}
