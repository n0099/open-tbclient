package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cTg;
    final /* synthetic */ a cVW;
    private final /* synthetic */ PersonalChatMessage cWc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.cVW = aVar;
        this.cWc = personalChatMessage;
        this.cTg = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.cWc.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cWc);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.cWc.getToUserId()), 2, this.cTg, 3)));
    }
}
