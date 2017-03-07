package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.PersonalChatMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        ImMessageCenterPojo Y;
        if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
            if (customResponsedMessage.getData() instanceof PersonalChatMessage) {
                b.asj().a(-1, ((PersonalChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.dfX));
                Y = b.asj().Y(String.valueOf(com.baidu.tieba.im.sendmessage.a.dfX), -1);
            } else if (customResponsedMessage.getData() instanceof OfficialChatMessage) {
                b.asj().a(-9, ((OfficialChatMessage) customResponsedMessage.getData()).getMsgId(), String.valueOf(com.baidu.tieba.im.sendmessage.a.dfY));
                Y = b.asj().Y(String.valueOf(com.baidu.tieba.im.sendmessage.a.dfY), -9);
            } else {
                ChatMessage chatMessage = (ChatMessage) customResponsedMessage.getData();
                b.asj().a(1, chatMessage.getMsgId(), chatMessage.getGroupId());
                Y = b.asj().Y(chatMessage.getGroupId(), 1);
            }
            CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new bc(this, Y));
            customMessageTask.setParallel(TiebaIMConfig.getParallel());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
            customMessageTask.setPriority(4);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
        }
    }
}
