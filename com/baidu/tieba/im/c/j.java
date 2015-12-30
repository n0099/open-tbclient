package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bXV;
    final /* synthetic */ a caF;
    private final /* synthetic */ CommonGroupChatMessage caK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.caF = aVar;
        this.caK = commonGroupChatMessage;
        this.bXV = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.caK.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.caK);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.caK.getGroupId(), this.bXV.getCustomGroupType(), this.bXV, 3)));
    }
}
