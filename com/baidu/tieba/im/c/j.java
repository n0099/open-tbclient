package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ a bmC;
    private final /* synthetic */ CommonGroupChatMessage bmH;
    private final /* synthetic */ ChatMessage val$chatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.bmC = aVar;
        this.bmH = commonGroupChatMessage;
        this.val$chatMessage = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        this.bmH.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bmH);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(this.bmH.getGroupId(), this.val$chatMessage.getCustomGroupType(), this.val$chatMessage, 3)));
    }
}
