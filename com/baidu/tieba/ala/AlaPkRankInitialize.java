package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes4.dex */
public class AlaPkRankInitialize {
    static {
        bOZ();
        bPa();
        bPb();
        bPc();
    }

    private static void bOZ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913225, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913225, new com.baidu.tieba.ala.d.g(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bPa() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913226, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913226, new com.baidu.tieba.ala.d.d(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bPb() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913229, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.d> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913229, com.baidu.tieba.ala.h.c.coM());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bPc() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913230, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.c> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913230, new com.baidu.tieba.ala.h.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
