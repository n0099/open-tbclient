package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class q implements com.baidu.tieba.im.g<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bmE;
    final /* synthetic */ o bmJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bmJ = oVar;
        this.bmE = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bmE);
    }
}
