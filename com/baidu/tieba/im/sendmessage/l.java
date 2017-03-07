package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements com.baidu.tbadk.util.f<Boolean> {
    private final /* synthetic */ ChatMessage ddo;
    final /* synthetic */ a dgf;
    private final /* synthetic */ PersonalChatMessage dgl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(a aVar, PersonalChatMessage personalChatMessage, ChatMessage chatMessage) {
        this.dgf = aVar;
        this.dgl = personalChatMessage;
        this.ddo = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.f
    public void onReturnDataInUI(Boolean bool) {
        this.dgl.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dgl);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(String.valueOf(this.dgl.getToUserId()), 2, this.ddo, 3)));
    }
}
