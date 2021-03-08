package com.baidu.tieba.ala.anchortask;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.b.a;
/* loaded from: classes10.dex */
public class AnchorTaskInitialize {
    static {
        bSP();
    }

    private static void bSP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913139, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.anchortask.AnchorTaskInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913139, new com.baidu.tieba.ala.anchortask.a.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
