package com.baidu.tieba.ala.headline;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.d.j;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.headline.dialog.AlaHeadlineActivity;
/* loaded from: classes11.dex */
public class AlaHeadlineInitialize {
    static {
        bZP();
        bZO();
    }

    private static void bZO() {
        TbadkCoreApplication.getInst().RegisterIntent(j.class, AlaHeadlineActivity.class);
    }

    private static void bZP() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913240, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.headline.AlaHeadlineInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.l.a> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913240, new com.baidu.tieba.ala.headline.a.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
