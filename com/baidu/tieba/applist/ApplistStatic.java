package com.baidu.tieba.applist;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.coreExtra.data.e;
/* loaded from: classes3.dex */
public class ApplistStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001370, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.applist.ApplistStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Object> customMessage) {
                c.akK().eG(false);
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001434) { // from class: com.baidu.tieba.applist.ApplistStatic.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof e)) {
                    new b().execute((e) customResponsedMessage.getData());
                }
            }
        });
    }
}
