package com.baidu.tieba.im.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.tieba.im.message.MemoryModifyLastMsgMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.CommonGroupChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements com.baidu.tbadk.util.g<Boolean> {
    private final /* synthetic */ ChatMessage dji;
    final /* synthetic */ a dlX;
    private final /* synthetic */ CommonGroupChatMessage dmc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar, CommonGroupChatMessage commonGroupChatMessage, ChatMessage chatMessage) {
        this.dlX = aVar;
        this.dmc = commonGroupChatMessage;
        this.dji = chatMessage;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tbadk.util.g
    public void onReturnDataInUI(Boolean bool) {
        this.dmc.setLogTime(System.currentTimeMillis());
        MessageManager.getInstance().sendMessage(this.dmc);
        MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyLastMsgMessage(new MemoryModifyLastMsgMessage.a(this.dmc.getGroupId(), this.dji.getCustomGroupType(), this.dji, 3)));
    }
}
