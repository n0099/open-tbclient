package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ PersonalChatMessage cVZ;
    final /* synthetic */ o cWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(o oVar, PersonalChatMessage personalChatMessage) {
        this.cWe = oVar;
        this.cVZ = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.cVZ);
    }
}
