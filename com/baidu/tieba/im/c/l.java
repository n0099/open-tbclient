package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage cTM;
    final /* synthetic */ a cWB;
    private final /* synthetic */ PersonalChatMessage cWH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.cWB = aVar;
        this.cWH = personalChatMessage;
        this.cTM = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.cWH.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.cWH);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.cWH.getToUserId()), 2, this.cTM, 3)));
    }
}
