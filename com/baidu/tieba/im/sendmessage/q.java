package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class q implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage daW;
    final /* synthetic */ o dbc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(o oVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.dbc = oVar;
        this.daW = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.daW);
    }
}
