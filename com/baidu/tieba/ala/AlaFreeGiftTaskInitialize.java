package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.c.f;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
/* loaded from: classes3.dex */
public class AlaFreeGiftTaskInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(f.class, AlaTaskListActivity.class);
        bjB();
    }

    private static void bjB() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913034, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaFreeGiftTaskInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.x.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913034, new com.baidu.tieba.ala.taskview.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913045, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaFreeGiftTaskInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.x.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913045, new com.baidu.tieba.ala.taskview.b());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2913136, new CustomMessageTask.CustomRunnable<Object>() { // from class: com.baidu.tieba.ala.AlaFreeGiftTaskInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.x.c> run(CustomMessage<Object> customMessage) {
                return new CustomResponsedMessage<>(2913136, com.baidu.tieba.ala.liveroom.task.b.bAa());
            }
        });
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
    }
}
