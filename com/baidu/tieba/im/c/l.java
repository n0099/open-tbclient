package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cmU;
    final /* synthetic */ a cpJ;
    private final /* synthetic */ PersonalChatMessage cpP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.cpJ = aVar;
        this.cpP = personalChatMessage;
        this.cmU = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.cpP.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cpP);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.cpP.getToUserId()), 2, this.cmU, 3)));
    }
}
