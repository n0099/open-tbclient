package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cWb;
    final /* synthetic */ a cYR;
    private final /* synthetic */ CommonGroupChatMessage cYW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.cYR = aVar;
        this.cYW = commonGroupChatMessage;
        this.cWb = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.cYW.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cYW);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.cYW.getGroupId(), this.cWb.getCustomGroupType(), this.cWb, 3)));
    }
}
