package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.h<Boolean> {
    private final /* synthetic */ ChatMessage dlz;
    final /* synthetic */ a don;
    private final /* synthetic */ OfficialChatMessage dou;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.don = aVar;
        this.dou = officialChatMessage;
        this.dlz = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        this.dou.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dou);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.dou.getToUserId()), 4, this.dlz, 3)));
    }
}
