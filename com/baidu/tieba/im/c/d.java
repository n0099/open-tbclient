package com.baidu.tieba.im.c;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.util.d<Boolean> {
    final /* synthetic */ b bHg;
    private final /* synthetic */ CommonGroupChatMessage bHh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.bHg = bVar;
        this.bHh = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        a.i(this.bHh);
    }
}
