package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bFc;
    final /* synthetic */ a bHA;
    private final /* synthetic */ CommonGroupChatMessage bHF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.bHA = aVar;
        this.bHF = commonGroupChatMessage;
        this.bFc = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bHF.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bHF);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.bHF.getGroupId(), this.bFc.getCustomGroupType(), this.bFc, 3)));
    }
}
