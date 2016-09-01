package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage dhL;
    final /* synthetic */ a dkA;
    private final /* synthetic */ OfficialChatMessage dkH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(a aVar, OfficialChatMessage officialChatMessage, ChatMessage chatMessage) {
        this.dkA = aVar;
        this.dkH = officialChatMessage;
        this.dhL = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.dkH.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dkH);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.dkH.getToUserId()), 4, this.dhL, 3)));
    }
}
