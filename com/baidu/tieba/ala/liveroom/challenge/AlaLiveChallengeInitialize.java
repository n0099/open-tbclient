package com.baidu.tieba.ala.liveroom.challenge;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes7.dex */
public class AlaLiveChallengeInitialize {
    static {
        bPk();
        TbadkCoreApplication.getInst().RegisterIntent(com.baidu.live.c.c.class, AlaChallengeShowAllJinzhuActivity.class);
    }

    private static void bPk() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913074, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.liveroom.challenge.AlaLiveChallengeInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.challenge.e> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913074, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
