package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage cVY;
    final /* synthetic */ o cWe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.cWe = oVar;
        this.cVY = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.cVY);
    }
}
