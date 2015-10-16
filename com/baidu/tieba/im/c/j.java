package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bEH;
    final /* synthetic */ a bHf;
    private final /* synthetic */ CommonGroupChatMessage bHk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.bHf = aVar;
        this.bHk = commonGroupChatMessage;
        this.bEH = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bHk.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bHk);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.bHk.getGroupId(), this.bEH.getCustomGroupType(), this.bEH, 3)));
    }
}
