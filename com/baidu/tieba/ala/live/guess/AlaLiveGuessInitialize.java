package com.baidu.tieba.ala.live.guess;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.guess.d;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes10.dex */
public class AlaLiveGuessInitialize {
    static {
        bXy();
        bXz();
        bXA();
    }

    private static void bXy() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913247, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.live.guess.AlaLiveGuessInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.guess.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913247, new b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bXz() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913299, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.live.guess.AlaLiveGuessInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.guess.b> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913299, new com.baidu.tieba.ala.live.guess.b.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bXA() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913298, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.live.guess.AlaLiveGuessInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<d> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913298, new com.baidu.tieba.ala.live.guess.group.b());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
