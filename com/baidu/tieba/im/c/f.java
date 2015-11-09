package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* loaded from: classes.dex */
class f implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ b bHB;
    private final /* synthetic */ PersonalChatMessage bHD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar, PersonalChatMessage personalChatMessage) {
        this.bHB = bVar;
        this.bHD = personalChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bHD);
    }
}
