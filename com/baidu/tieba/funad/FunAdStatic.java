package com.baidu.tieba.funad;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.h.a;
/* loaded from: classes5.dex */
public class FunAdStatic {
    public static String Tag = "tag";

    static {
        com.baidu.tieba.h.b.jUD.set(new d());
        cND();
    }

    private static void cND() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921525, new CustomMessageTask.CustomRunnable<a.InterfaceC0749a>() { // from class: com.baidu.tieba.funad.FunAdStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a.InterfaceC0749a> run(CustomMessage<a.InterfaceC0749a> customMessage) {
                return new CustomResponsedMessage<>(2921525, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
