package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage dbK;
    final /* synthetic */ a deC;
    private final /* synthetic */ OfficialChatMessage deJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.deC = aVar;
        this.deJ = officialChatMessage;
        this.dbK = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.deJ.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.deJ);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.deJ.getToUserId()), 4, this.dbK, 3)));
    }
}
