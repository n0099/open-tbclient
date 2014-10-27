package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class z implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ x aNN;
    private final /* synthetic */ CommonGroupChatMessage aNO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(x xVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.aNN = xVar;
        this.aNO = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aNO);
    }
}
