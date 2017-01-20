package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage daW;
    final /* synthetic */ a ddN;
    private final /* synthetic */ CommonGroupChatMessage ddS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.ddN = aVar;
        this.ddS = commonGroupChatMessage;
        this.daW = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.ddS.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.ddS);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.ddS.getGroupId(), this.daW.getCustomGroupType(), this.daW, 3)));
    }
}
