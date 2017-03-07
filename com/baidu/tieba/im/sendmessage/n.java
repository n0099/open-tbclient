package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage ddo;
    final /* synthetic */ a dgf;
    private final /* synthetic */ OfficialChatMessage dgm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.dgf = aVar;
        this.dgm = officialChatMessage;
        this.ddo = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.dgm.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dgm);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.dgm.getToUserId()), 4, this.ddo, 3)));
    }
}
