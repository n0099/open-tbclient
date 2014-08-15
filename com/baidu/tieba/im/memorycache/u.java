package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.data.MsgLocalData;
import com.baidu.tieba.im.message.ResponseCommitGroupMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null || !(socketResponsedMessage instanceof ResponseCommitGroupMessage)) {
            return;
        }
        this.a.a(socketResponsedMessage);
        ChatMessage chatMessage = (ChatMessage) socketResponsedMessage.getOrginalMessage();
        if (chatMessage.getLocalData() == null) {
            chatMessage.setLocalData(new MsgLocalData());
        }
        if (socketResponsedMessage.hasError()) {
            chatMessage.getLocalData().setStatus((short) 2);
        } else {
            chatMessage.getLocalData().setStatus((short) 3);
            long msgId = ((ResponseCommitGroupMessage) socketResponsedMessage).getMsgId();
            String groupId = ((ResponseCommitGroupMessage) socketResponsedMessage).getGroupId();
            long recordId = ((ResponseCommitGroupMessage) socketResponsedMessage).getRecordId();
            chatMessage.setMsgId(msgId);
            chatMessage.setRecordId(recordId);
            c.b().a(chatMessage.getCustomGroupType(), msgId, groupId);
        }
        c.b().a(chatMessage.getCustomGroupType(), chatMessage, chatMessage.getGroupId(), false);
        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new v(this, c.b().a(chatMessage.getGroupId(), chatMessage.getCustomGroupType()), chatMessage, socketResponsedMessage));
        customMessageTask.setParallel(com.baidu.tbadk.k.b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        customMessageTask.setPriority(4);
        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
    }
}
