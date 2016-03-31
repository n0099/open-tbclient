package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cmU;
    final /* synthetic */ a cpJ;
    private final /* synthetic */ CommonGroupChatMessage cpO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.cpJ = aVar;
        this.cpO = commonGroupChatMessage;
        this.cmU = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.cpO.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cpO);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.cpO.getGroupId(), this.cmU.getCustomGroupType(), this.cmU, 3)));
    }
}
