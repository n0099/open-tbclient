package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.a<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage aNO;
    final /* synthetic */ ak aNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.aNV = akVar;
        this.aNO = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        w.a(this.aNO);
    }
}
