package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ ChatMessage aNS;
    private final /* synthetic */ PersonalChatMessage aNT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(w wVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.aNM = wVar;
        this.aNT = personalChatMessage;
        this.aNS = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        this.aNT.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.aNT);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(String.valueOf(this.aNT.getToUserId()), 2, this.aNS, 3)));
    }
}
