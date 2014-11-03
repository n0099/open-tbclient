package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ ChatMessage aOg;
    private final /* synthetic */ OfficialChatMessage aOi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(w wVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.aOa = wVar;
        this.aOi = officialChatMessage;
        this.aOg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        this.aOi.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.aOi);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(String.valueOf(this.aOi.getToUserId()), 4, this.aOg, 3)));
    }
}
