package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.util.h<Boolean> {
    final /* synthetic */ b doo;
    private final /* synthetic */ PersonalChatMessage doq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, PersonalChatMessage personalChatMessage) {
        this.doo = bVar;
        this.doq = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.doq);
    }
}
