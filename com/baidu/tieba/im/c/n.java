package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bXV;
    final /* synthetic */ a caF;
    private final /* synthetic */ OfficialChatMessage caM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.caF = aVar;
        this.caM = officialChatMessage;
        this.bXV = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.caM.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.caM);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.caM.getToUserId()), 4, this.bXV, 3)));
    }
}
