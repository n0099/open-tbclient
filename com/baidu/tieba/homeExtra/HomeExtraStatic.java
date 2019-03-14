package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.r.c;
/* loaded from: classes6.dex */
public class HomeExtraStatic {
    static {
        MessageManager.getInstance().registerTask(new a());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001407, true));
        CustomMessageTask customMessageTask = new CustomMessageTask(2156671, new CustomMessageTask.CustomRunnable<c.a>() { // from class: com.baidu.tieba.homeExtra.HomeExtraStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c.a> run(CustomMessage<c.a> customMessage) {
                return new CustomResponsedMessage<>(2156671, new com.baidu.tieba.homeExtra.b.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
