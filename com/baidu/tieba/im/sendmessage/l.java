package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage cYd;
    final /* synthetic */ a daU;
    private final /* synthetic */ PersonalChatMessage dba;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.daU = aVar;
        this.dba = personalChatMessage;
        this.cYd = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.dba.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dba);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.dba.getToUserId()), 2, this.cYd, 3)));
    }
}
