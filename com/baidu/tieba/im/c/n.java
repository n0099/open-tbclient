package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cnR;
    final /* synthetic */ a cqG;
    private final /* synthetic */ OfficialChatMessage cqN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.cqG = aVar;
        this.cqN = officialChatMessage;
        this.cnR = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.cqN.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cqN);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.cqN.getToUserId()), 4, this.cnR, 3)));
    }
}
