package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.g<Boolean> {
    private final /* synthetic */ CommonGroupChatMessage bpC;
    final /* synthetic */ a bpx;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.bpx = aVar;
        this.bpC = commonGroupChatMessage;
        this.val$chatMessage = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        this.bpC.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bpC);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(this.bpC.getGroupId(), this.val$chatMessage.getCustomGroupType(), this.val$chatMessage, 3)));
    }
}
