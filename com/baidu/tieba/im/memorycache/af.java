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
        MemoryModifyVisibilityMessage.a data;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016005 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
            ImMessageCenterPojo af = b.arI().af(data.id, data.customGroupType);
            int i = data.visible ? 0 : 1;
            if (af != null && i != af.getIs_hidden()) {
                if (data.customGroupType == 2) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().et(data.id);
                } else if (data.customGroupType == 4) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().dG(com.baidu.adp.lib.h.b.g(data.id, 0));
                } else if (data.customGroupType == -3) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().dH(2);
                } else if (data.customGroupType == -4) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().dH(1);
                } else if (data.customGroupType == -5) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().dH(3);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().es(data.id);
                }
                b.arI().f(data.id, data.customGroupType, data.visible);
                af.setIs_hidden(i);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new ag(this, af));
                customMessageTask.setParallel(TiebaIMConfig.getParallel());
                customMessageTask.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }
}
