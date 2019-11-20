package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.challenge.g;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class AlaLiveChallengeExtraInitialize {
    static {
        aPT();
    }

    private static void aPT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913114, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaLiveChallengeExtraInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<g> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2913114, new b(customMessage.getData().getPageActivity()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2913088, new CustomMessageTask.CustomRunnable<com.baidu.live.challenge.c>() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaLiveChallengeExtraInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.challenge.c> run(CustomMessage<com.baidu.live.challenge.c> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    com.baidu.tieba.ala.liveroom.challenge.rewarddialog.e.aQO().a(customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
