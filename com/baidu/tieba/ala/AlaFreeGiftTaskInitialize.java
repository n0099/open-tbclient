package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.tasklist.AlaTaskListActivity;
/* loaded from: classes6.dex */
public class AlaFreeGiftTaskInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.b.d.class, AlaTaskListActivity.class);
        aIC();
    }

    private static void aIC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913034, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaFreeGiftTaskInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.m.b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913034, new com.baidu.tieba.ala.taskview.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913045, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaFreeGiftTaskInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.m.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913045, new com.baidu.tieba.ala.taskview.b());
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
