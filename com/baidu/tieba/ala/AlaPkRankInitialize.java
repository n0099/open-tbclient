package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.ala.h.k;
import com.baidu.tieba.ala.h.o;
/* loaded from: classes11.dex */
public class AlaPkRankInitialize {
    static {
        bOq();
        bOr();
        bOs();
        bOw();
        bOt();
        bOu();
        bOv();
    }

    private static void bOq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913225, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913225, new com.baidu.tieba.ala.d.g(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913226, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.c> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913226, new com.baidu.tieba.ala.d.d(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913229, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.e> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913229, k.coX());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913292, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913292, com.baidu.tieba.ala.h.g.coV());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOu() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913296, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.5
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913296, com.baidu.tieba.ala.h.b.coT());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOv() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913293, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.6
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.f> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913293, o.cpa());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOw() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913230, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaPkRankInitialize.7
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.d> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913230, new com.baidu.tieba.ala.h.i());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
