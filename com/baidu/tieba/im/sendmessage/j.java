package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage ddo;
    final /* synthetic */ a dgf;
    private final /* synthetic */ CommonGroupChatMessage dgk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.dgf = aVar;
        this.dgk = commonGroupChatMessage;
        this.ddo = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.dgk.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dgk);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.dgk.getGroupId(), this.ddo.getCustomGroupType(), this.ddo, 3)));
    }
}
