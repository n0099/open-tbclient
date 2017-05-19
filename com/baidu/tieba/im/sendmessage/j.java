package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cYd;
    final /* synthetic */ a daU;
    private final /* synthetic */ CommonGroupChatMessage daZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.daU = aVar;
        this.daZ = commonGroupChatMessage;
        this.cYd = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.daZ.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.daZ);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.daZ.getGroupId(), this.cYd.getCustomGroupType(), this.cYd, 3)));
    }
}
