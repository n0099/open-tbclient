package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ a bmC;
    private final /* synthetic */ OfficialChatMessage bmI;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.bmC = aVar;
        this.bmI = officialChatMessage;
        this.val$chatMessage = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        this.bmI.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bmI);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(this.bmI.getToUserId()), 4, this.val$chatMessage, 3)));
    }
}
