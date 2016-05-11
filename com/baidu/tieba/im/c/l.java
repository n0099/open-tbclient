package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cnR;
    final /* synthetic */ a cqG;
    private final /* synthetic */ PersonalChatMessage cqM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.cqG = aVar;
        this.cqM = personalChatMessage;
        this.cnR = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.cqM.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cqM);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.cqM.getToUserId()), 2, this.cnR, 3)));
    }
}
