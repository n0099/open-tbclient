package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage ccp;
    final /* synthetic */ a cfe;
    private final /* synthetic */ CommonGroupChatMessage cfj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.cfe = aVar;
        this.cfj = commonGroupChatMessage;
        this.ccp = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.cfj.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cfj);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.cfj.getGroupId(), this.ccp.getCustomGroupType(), this.ccp, 3)));
    }
}
