package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.ala.d.h;
/* loaded from: classes4.dex */
public class AlaSeriesGiftInitialize {
    static {
        bPi();
    }

    private static void bPi() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913239, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaSeriesGiftInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913239, new h(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
