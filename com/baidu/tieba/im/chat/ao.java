package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class ao implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ PersonalChatMessage aNP;
    final /* synthetic */ ak aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar, PersonalChatMessage personalChatMessage) {
        this.aNV = akVar;
        this.aNP = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aNP);
    }
}
