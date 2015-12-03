package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bUj;
    final /* synthetic */ a bWG;
    private final /* synthetic */ PersonalChatMessage bWM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.bWG = aVar;
        this.bWM = personalChatMessage;
        this.bUj = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bWM.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bWM);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.bWM.getToUserId()), 2, this.bUj, 3)));
    }
}
