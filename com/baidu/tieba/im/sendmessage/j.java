package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage dbK;
    final /* synthetic */ a deC;
    private final /* synthetic */ CommonGroupChatMessage deH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.deC = aVar;
        this.deH = commonGroupChatMessage;
        this.dbK = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.deH.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.deH);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.deH.getGroupId(), this.dbK.getCustomGroupType(), this.dbK, 3)));
    }
}
