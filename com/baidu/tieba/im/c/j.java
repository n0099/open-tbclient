package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage dhL;
    final /* synthetic */ a dkA;
    private final /* synthetic */ CommonGroupChatMessage dkF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.dkA = aVar;
        this.dkF = commonGroupChatMessage;
        this.dhL = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.dkF.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dkF);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.dkF.getGroupId(), this.dhL.getCustomGroupType(), this.dhL, 3)));
    }
}
