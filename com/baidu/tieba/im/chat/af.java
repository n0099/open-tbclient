package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w aOa;
    private final /* synthetic */ CommonGroupChatMessage aOf;
    private final /* synthetic */ ChatMessage aOg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(w wVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.aOa = wVar;
        this.aOf = commonGroupChatMessage;
        this.aOg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        this.aOf.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.aOf);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(this.aOf.getGroupId(), this.aOg.getCustomGroupType(), this.aOg, 3)));
    }
}
