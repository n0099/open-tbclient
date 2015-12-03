package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bUj;
    final /* synthetic */ a bWG;
    private final /* synthetic */ CommonGroupChatMessage bWL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.bWG = aVar;
        this.bWL = commonGroupChatMessage;
        this.bUj = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bWL.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bWL);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.bWL.getGroupId(), this.bUj.getCustomGroupType(), this.bUj, 3)));
    }
}
