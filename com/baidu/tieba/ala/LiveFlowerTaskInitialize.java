package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes4.dex */
public class LiveFlowerTaskInitialize {
    static {
        bMs();
        bMr();
    }

    private static void bMr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913219, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.LiveFlowerTaskInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.ad.d> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913219, new e(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bMs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913034, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.LiveFlowerTaskInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.ad.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913034, new com.baidu.tieba.ala.taskview.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913045, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.LiveFlowerTaskInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.ad.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913045, new com.baidu.tieba.ala.taskview.b());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2913136, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.LiveFlowerTaskInitialize.4
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.ad.c> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2913136, com.baidu.tieba.ala.liveroom.task.b.chp());
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }
}
