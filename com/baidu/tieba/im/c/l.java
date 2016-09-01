package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage dhL;
    final /* synthetic */ a dkA;
    private final /* synthetic */ PersonalChatMessage dkG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.dkA = aVar;
        this.dkG = personalChatMessage;
        this.dhL = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.dkG.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dkG);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.dkG.getToUserId()), 2, this.dhL, 3)));
    }
}
