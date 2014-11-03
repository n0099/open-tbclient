package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ ChatMessage aOg;
    private final /* synthetic */ PersonalChatMessage aOh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.aOa = wVar;
        this.aOh = personalChatMessage;
        this.aOg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        this.aOh.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.aOh);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(String.valueOf(this.aOh.getToUserId()), 2, this.aOg, 3)));
    }
}
