package com.baidu.tieba.ala.anchortask;

import android.app.Activity;
import android.content.Context;
import com.baidu.live.a.a;
import com.baidu.live.a.b;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes4.dex */
public class AnchorTaskInitialize {
    static {
        bNG();
    }

    private static void bNG() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913139, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.anchortask.AnchorTaskInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913139, new com.baidu.tieba.ala.anchortask.a.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913140, new CustomMessageTask.CustomRunnable<Activity>() { // from class: com.baidu.tieba.ala.anchortask.AnchorTaskInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<b> run(CustomMessage<Activity> customMessage) {
                return new CustomResponsedMessage<>(2913140, new com.baidu.tieba.ala.anchortask.a.b(customMessage.getData()));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
