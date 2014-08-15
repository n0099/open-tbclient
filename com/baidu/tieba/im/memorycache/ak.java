package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ImMessageCenterPojo a;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
            this.a.a(socketResponsedMessage);
            ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
            ChatMessage chatMessage = (ChatMessage) responseCommitPersonalMessage.getOrginalMessage();
            if (socketResponsedMessage.hasError()) {
                chatMessage.getLocalData().setStatus((short) 2);
            } else {
                long msgId = responseCommitPersonalMessage.getMsgId();
                long recordId = responseCommitPersonalMessage.getRecordId();
                chatMessage.setMsgId(msgId);
                chatMessage.setRecordId(recordId);
                chatMessage.getLocalData().setStatus((short) 3);
                com.baidu.tieba.im.chat.w.a(com.baidu.adp.lib.e.b.a(responseCommitPersonalMessage.getGroupId(), 0));
                c.b().a(-1, ((ResponseCommitPersonalMessage) socketResponsedMessage).getMsgId(), String.valueOf(com.baidu.tieba.im.chat.w.a));
            }
            if (chatMessage instanceof PersonalChatMessage) {
                c.b().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), false);
            } else if (chatMessage instanceof OfficialChatMessage) {
                c.b().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), false);
            } else {
                return;
            }
            ImMessageCenterPojo a2 = c.b().a(String.valueOf(com.baidu.tieba.im.chat.w.a), -1);
            if (chatMessage instanceof PersonalChatMessage) {
                a = c.b().a(String.valueOf(com.baidu.tieba.im.d.j.a(chatMessage)), 2);
            } else if (chatMessage instanceof OfficialChatMessage) {
                a = c.b().a(String.valueOf(com.baidu.tieba.im.d.j.a(chatMessage)), 4);
            } else {
                return;
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new al(this, a2, a, chatMessage, socketResponsedMessage));
            customMessageTask.setParallel(com.baidu.tbadk.k.b());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
