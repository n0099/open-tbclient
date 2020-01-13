package com.baidu.tieba.ala.guardthrone;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaGuardThroneActivityConfig;
import com.baidu.tieba.ala.guardthrone.c.a;
/* loaded from: classes2.dex */
public class GuardThroneInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(AlaGuardThroneActivityConfig.class, GuardThroneActivity.class);
        CustomMessageTask customMessageTask = new CustomMessageTask(2913147, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.guardthrone.GuardThroneInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913147, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
