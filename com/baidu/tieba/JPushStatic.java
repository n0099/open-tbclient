package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.q.b;
/* loaded from: classes3.dex */
public class JPushStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2156672, new CustomMessageTask.CustomRunnable<b.a>() { // from class: com.baidu.tieba.JPushStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<b.a> run(CustomMessage<b.a> customMessage) {
                return new CustomResponsedMessage<>(2156672, new c());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
