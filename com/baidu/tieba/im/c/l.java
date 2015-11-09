package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bFc;
    final /* synthetic */ a bHA;
    private final /* synthetic */ PersonalChatMessage bHG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.bHA = aVar;
        this.bHG = personalChatMessage;
        this.bFc = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bHG.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bHG);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.bHG.getToUserId()), 2, this.bFc, 3)));
    }
}
