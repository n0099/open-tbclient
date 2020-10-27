package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes4.dex */
public class AlaPkRankInitialize {
    static {
        bJx();
        bJy();
        bJz();
        bJA();
    }

    private static void bJx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913225, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.q.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913225, new com.baidu.tieba.ala.d.f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bJy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913226, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.q.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913226, new com.baidu.tieba.ala.d.c(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bJz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913229, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.q.d> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913229, com.baidu.tieba.ala.h.c.ciy());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bJA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913230, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.q.c> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913230, new com.baidu.tieba.ala.h.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
