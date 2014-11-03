package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ak(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ImMessageCenterPojo B;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
            this.this$0.f(socketResponsedMessage);
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
                com.baidu.tieba.im.chat.w.fm(com.baidu.adp.lib.g.c.f(responseCommitPersonalMessage.getGroupId(), 0));
            }
            if (chatMessage instanceof PersonalChatMessage) {
                c.PN().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
            } else if (chatMessage instanceof OfficialChatMessage) {
                c.PN().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
            } else {
                return;
            }
            if (chatMessage instanceof PersonalChatMessage) {
                B = c.PN().B(String.valueOf(com.baidu.tieba.im.util.i.o(chatMessage)), 2);
            } else if (chatMessage instanceof OfficialChatMessage) {
                B = c.PN().B(String.valueOf(com.baidu.tieba.im.util.i.o(chatMessage)), 4);
            } else {
                return;
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new al(this, B, chatMessage, socketResponsedMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
