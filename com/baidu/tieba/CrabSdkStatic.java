package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.r.a;
/* loaded from: classes3.dex */
public class CrabSdkStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016565, new CustomMessageTask.CustomRunnable<a.InterfaceC0498a>() { // from class: com.baidu.tieba.CrabSdkStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a.InterfaceC0498a> run(CustomMessage<a.InterfaceC0498a> customMessage) {
                return new CustomResponsedMessage<>(2016565, new com.baidu.tieba.d.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
