package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ b dgs;
    private final /* synthetic */ PersonalChatMessage dgu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, PersonalChatMessage personalChatMessage) {
        this.dgs = bVar;
        this.dgu = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.dgu);
    }
}
