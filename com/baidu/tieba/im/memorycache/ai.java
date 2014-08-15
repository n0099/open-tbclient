package com.baidu.tieba.im.memorycache;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends CustomMessageListener {
    final /* synthetic */ ImMemoryCacheRegisterStatic a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ImMemoryCacheRegisterStatic imMemoryCacheRegisterStatic, int i) {
        super(i);
        this.a = imMemoryCacheRegisterStatic;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        com.baidu.tieba.im.message.h data;
        if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2016004 && (customResponsedMessage instanceof MemoryModifyVisibilityMessage) && (data = ((MemoryModifyVisibilityMessage) customResponsedMessage).getData()) != null) {
            ImMessageCenterPojo a = c.b().a(data.a, data.b);
            int i = data.c ? 0 : 1;
            if (a != null && i != a.getIs_hidden()) {
                if (data.b == 2) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().b(data.a);
                } else if (data.b == 4) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().f();
                } else if (data.b == -3) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(2);
                } else if (data.b == -4) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(1);
                } else if (data.b == -5) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(3);
                } else {
                    com.baidu.tbadk.coreExtra.messageCenter.a.a().a(data.a);
                }
                c.b().b(data.a, data.b, data.c);
                a.setIs_hidden(i);
                CustomMessageTask customMessageTask = new CustomMessageTask(2001000, new aj(this, a));
                customMessageTask.setParallel(com.baidu.tbadk.k.b());
                customMessageTask.a(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
                customMessageTask.setPriority(4);
                MessageManager.getInstance().sendMessage(new CustomMessage(2001000, data), customMessageTask);
            }
        }
    }
}
