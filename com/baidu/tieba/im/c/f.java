package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ b bnj;
    private final /* synthetic */ PersonalChatMessage bnl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, PersonalChatMessage personalChatMessage) {
        this.bnj = bVar;
        this.bnl = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        a.h(this.bnl);
    }
}
