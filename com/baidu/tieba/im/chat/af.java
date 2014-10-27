package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af implements com.baidu.tieba.im.a<Boolean> {
    final /* synthetic */ w aNM;
    private final /* synthetic */ CommonGroupChatMessage aNR;
    private final /* synthetic */ ChatMessage aNS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(w wVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.aNM = wVar;
        this.aNR = commonGroupChatMessage;
        this.aNS = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.im.a
    public void onReturnDataInUI(Boolean bool) {
        this.aNR.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.aNR);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new com.baidu.tieba.im.message.f(this.aNR.getGroupId(), this.aNS.getCustomGroupType(), this.aNS, 3)));
    }
}
