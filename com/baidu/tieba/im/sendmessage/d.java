package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.util.f<Boolean> {
    final /* synthetic */ b deD;
    private final /* synthetic */ CommonGroupChatMessage deE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.deD = bVar;
        this.deE = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        a.h(this.deE);
    }
}
