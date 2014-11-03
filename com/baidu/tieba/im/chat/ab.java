package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class ab implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x aOb;
    private final /* synthetic */ PersonalChatMessage aOd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(x xVar, PersonalChatMessage personalChatMessage) {
        this.aOb = xVar;
        this.aOd = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aOd);
    }
}
