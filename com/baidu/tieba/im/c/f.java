package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.util.g<Boolean> {
    final /* synthetic */ b cqH;
    private final /* synthetic */ PersonalChatMessage cqJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, PersonalChatMessage personalChatMessage) {
        this.cqH = bVar;
        this.cqJ = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.cqJ);
    }
}
