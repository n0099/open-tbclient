package com.baidu.tieba.im.chat;

import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* loaded from: classes.dex */
class am implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ ak a;
    private final /* synthetic */ CommonGroupChatMessage b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar, CommonGroupChatMessage commonGroupChatMessage) {
        this.a = akVar;
        this.b = commonGroupChatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        w.a(this.b);
    }
}
