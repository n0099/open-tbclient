package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.ResponsedPersonalMsgReadMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class au extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public au(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage != null && socketResponsedMessage.getCmd() == 205006 && (socketResponsedMessage instanceof ResponsedPersonalMsgReadMessage)) {
            ResponsedPersonalMsgReadMessage responsedPersonalMsgReadMessage = (ResponsedPersonalMsgReadMessage) socketResponsedMessage;
            if (!responsedPersonalMsgReadMessage.hasError() && responsedPersonalMsgReadMessage.getGroupId() == com.baidu.tieba.im.c.a.bHs && responsedPersonalMsgReadMessage.getToUserType() == 0) {
                ImMessageCenterPojo J = b.Wn().J(String.valueOf(responsedPersonalMsgReadMessage.getToUid()), 2);
                if (J != null) {
                    long aJ = com.baidu.tieba.im.util.g.aJ(responsedPersonalMsgReadMessage.getHasSentMsgId());
                    if (aJ > J.getSent_msgId()) {
                        J.setSent_msgId(aJ);
                        CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new av(this, J));
                        customMessageTask.setParallel(TiebaIMConfig.getParallel());
                        customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                        customMessageTask.setPriority(4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2001000), customMessageTask);
                    }
                }
            }
        }
    }
}
