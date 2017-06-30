package com.baidu.tieba.im.sendmessage;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.h<Boolean> {
    private final /* synthetic */ ChatMessage dlz;
    final /* synthetic */ a don;
    private final /* synthetic */ CommonGroupChatMessage dos;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.don = aVar;
        this.dos = commonGroupChatMessage;
        this.dlz = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.h
    public void onReturnDataInUI(Boolean bool) {
        this.dos.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dos);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.dos.getGroupId(), this.dlz.getCustomGroupType(), this.dlz, 3)));
    }
}
