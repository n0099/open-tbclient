package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ b bnj;
    private final /* synthetic */ CommonGroupChatMessage bnk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bnj = bVar;
        this.bnk = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        a.h(this.bnk);
    }
}
