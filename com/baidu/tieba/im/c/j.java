package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage doR;
    final /* synthetic */ a drH;
    private final /* synthetic */ CommonGroupChatMessage drM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.drH = aVar;
        this.drM = commonGroupChatMessage;
        this.doR = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.drM.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.drM);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.drM.getGroupId(), this.doR.getCustomGroupType(), this.doR, 3)));
    }
}
