package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage ded;
    final /* synthetic */ a dgT;
    private final /* synthetic */ CommonGroupChatMessage dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.dgT = aVar;
        this.dgY = commonGroupChatMessage;
        this.ded = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.dgY.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dgY);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.dgY.getGroupId(), this.ded.getCustomGroupType(), this.ded, 3)));
    }
}
