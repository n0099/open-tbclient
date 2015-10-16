package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.d<Boolean> {
    private final /* synthetic */ ChatMessage bEH;
    final /* synthetic */ a bHf;
    private final /* synthetic */ PersonalChatMessage bHl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.bHf = aVar;
        this.bHl = personalChatMessage;
        this.bEH = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.d
    public void onReturnDataInUI(Boolean bool) {
        this.bHl.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.bHl);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.bHl.getToUserId()), 2, this.bEH, 3)));
    }
}
