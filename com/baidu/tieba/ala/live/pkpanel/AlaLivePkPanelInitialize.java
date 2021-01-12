package com.baidu.tieba.ala.live.pkpanel;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
/* loaded from: classes10.dex */
public class AlaLivePkPanelInitialize {
    static {
        bXL();
    }

    private static void bXL() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913256, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.live.pkpanel.AlaLivePkPanelInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.t.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913256, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
