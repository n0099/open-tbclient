package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.TiebaIMConfig;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class af extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.this$0 = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.message.h data;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
            ImMessageCenterPojo D = c.Sd().D(data.id, data.customGroupType);
            int i = data.ahV ? 0 : 1;
            if (D != null && i != D.getIs_hidden()) {
                if (data.customGroupType == 2) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().dq(data.id);
                } else if (data.customGroupType == 4) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().cC(com.baidu.adp.lib.g.c.toInt(data.id, 0));
                } else if (data.customGroupType == -3) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().cD(2);
                } else if (data.customGroupType == -4) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().cD(1);
                } else if (data.customGroupType == -5) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().cD(3);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().dp(data.id);
                }
                c.Sd().e(data.id, data.customGroupType, data.ahV);
                D.setIs_hidden(i);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new ag(this, D));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }
}
