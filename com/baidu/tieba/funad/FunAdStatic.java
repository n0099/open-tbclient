package com.baidu.tieba.funad;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.h.a;
/* loaded from: classes3.dex */
public class FunAdStatic {
    public static String Tag = "tag";

    static {
        com.baidu.tieba.h.b.jQy.set(new d());
        cPs();
    }

    private static void cPs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921525, new CustomMessageTask.CustomRunnable<a.b>() { // from class: com.baidu.tieba.funad.FunAdStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a.b> run(CustomMessage<a.b> customMessage) {
                return new CustomResponsedMessage<>(2921525, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
