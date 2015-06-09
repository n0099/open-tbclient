package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tieba.im.g<Boolean> {
    final /* synthetic */ a bpy;
    private final /* synthetic */ ChatMessage val$chatMessage;
    private final /* synthetic */ PersonalChatMessage val$personalChatMessage;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.bpy = aVar;
        this.val$personalChatMessage = personalChatMessage;
        this.val$chatMessage = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.g
    public void onReturnDataInUI(Boolean bool) {
        this.val$personalChatMessage.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.val$personalChatMessage);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.g(String.valueOf(this.val$personalChatMessage.getToUserId()), 2, this.val$chatMessage, 3)));
    }
}
