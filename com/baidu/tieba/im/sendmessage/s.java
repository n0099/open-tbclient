package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ PersonalChatMessage dgu;
    final /* synthetic */ o dgz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PersonalChatMessage personalChatMessage) {
        this.dgz = oVar;
        this.dgu = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.dgu);
    }
}
