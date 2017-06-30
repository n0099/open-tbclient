package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.util.h<Boolean> {
    private final /* synthetic */ PersonalChatMessage doq;
    final /* synthetic */ o dov;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PersonalChatMessage personalChatMessage) {
        this.dov = oVar;
        this.doq = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.doq);
    }
}
