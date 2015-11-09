package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bFc;
    final /* synthetic */ a bHA;
    private final /* synthetic */ OfficialChatMessage bHH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.bHA = aVar;
        this.bHH = officialChatMessage;
        this.bFc = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bHH.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bHH);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.bHH.getToUserId()), 4, this.bFc, 3)));
    }
}
