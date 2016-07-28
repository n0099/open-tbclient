package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tbadk.core.atomData.CreateGroupActivityActivityConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponseCommitPersonalMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ImMessageCenterPojo ah;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseCommitPersonalMessage)) {
            ResponseCommitPersonalMessage responseCommitPersonalMessage = (ResponseCommitPersonalMessage) socketResponsedMessage;
            ChatMessage chatMessage = (ChatMessage) responseCommitPersonalMessage.getOrginalMessage();
            int toUserType = responseCommitPersonalMessage.getToUserType();
            if (socketResponsedMessage.hasError()) {
                chatMessage.getLocalData().setStatus((short) 2);
            } else {
                long msgId = responseCommitPersonalMessage.getMsgId();
                long recordId = responseCommitPersonalMessage.getRecordId();
                chatMessage.setMsgId(msgId);
                chatMessage.setRecordId(recordId);
                chatMessage.getLocalData().setStatus((short) 3);
                if (responseCommitPersonalMessage.getToUserType() == 0) {
                    com.baidu.tieba.im.c.a.lm(com.baidu.adp.lib.h.b.g(responseCommitPersonalMessage.getGroupId(), 0));
                } else {
                    com.baidu.tieba.im.c.a.ln(com.baidu.adp.lib.h.b.g(responseCommitPersonalMessage.getGroupId(), 0));
                }
            }
            com.baidu.tbadk.core.log.b.a("im", chatMessage.getClientLogID(), chatMessage.getCmd(), "ack", socketResponsedMessage.getError(), socketResponsedMessage.getErrorString(), "comment", "uType " + toUserType, "touid", Long.valueOf(chatMessage.getToUserId()), CreateGroupActivityActivityConfig.GROUP_ACTIVITY_CONTENT, chatMessage.getContent());
            if (chatMessage instanceof PersonalChatMessage) {
                b.apZ().a(2, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
            } else if (chatMessage instanceof OfficialChatMessage) {
                b.apZ().a(4, chatMessage, String.valueOf(chatMessage.getToUserId()), 3);
            } else {
                return;
            }
            if (chatMessage instanceof PersonalChatMessage) {
                ah = b.apZ().ah(String.valueOf(com.baidu.tieba.im.util.h.p(chatMessage)), 2);
            } else if (chatMessage instanceof OfficialChatMessage) {
                ah = b.apZ().ah(String.valueOf(com.baidu.tieba.im.util.h.p(chatMessage)), 4);
            } else {
                return;
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new am(this, ah, chatMessage, socketResponsedMessage));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
