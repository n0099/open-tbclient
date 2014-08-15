package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w a;
    private final /* synthetic */ PersonalChatMessage b;
    private final /* synthetic */ ChatMessage c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.a = wVar;
        this.b = personalChatMessage;
        this.c = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void a(Boolean bool) {
        this.b.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.b);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(this.b.getToUserId()), 2, this.c, false)));
    }
}
