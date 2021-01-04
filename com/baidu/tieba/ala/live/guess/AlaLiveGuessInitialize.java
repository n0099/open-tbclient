package com.baidu.tieba.ala.live.guess;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes11.dex */
public class AlaLiveGuessInitialize {
    static {
        caC();
    }

    private static void caC() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913247, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.live.guess.AlaLiveGuessInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.guess.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913247, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
