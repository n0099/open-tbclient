package com.baidu.tieba.im.sendmessage;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.util.h<Boolean> {
    final /* synthetic */ b doo;
    private final /* synthetic */ CommonGroupChatMessage dop;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.doo = bVar;
        this.dop = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        a.j(this.dop);
    }
}
