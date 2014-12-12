package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class s implements com.baidu.tieba.im.g<Boolean> {
    private final /* synthetic */ PersonalChatMessage bnl;
    final /* synthetic */ o bnp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PersonalChatMessage personalChatMessage) {
        this.bnp = oVar;
        this.bnl = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        a.h(this.bnl);
    }
}
