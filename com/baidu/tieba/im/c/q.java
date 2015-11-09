package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bHC;
    final /* synthetic */ o bHI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bHI = oVar;
        this.bHC = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bHC);
    }
}
