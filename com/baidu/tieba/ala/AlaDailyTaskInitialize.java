package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes11.dex */
public class AlaDailyTaskInitialize {
    static {
        bRo();
    }

    private static void bRo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913278, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaDailyTaskInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.h.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913278, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
