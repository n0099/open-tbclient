package com.baidu.tieba.frs.frsfeedforums;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsMoreFeedForumsConfig;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.tbadkCore.h;
/* loaded from: classes3.dex */
public class FrsMoreFeedForumsActivityStatic {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(FrsMoreFeedForumsConfig.class, FrsMoreFeedForumsActivity.class);
        aDq();
        aDr();
    }

    private static void aDq() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2003008) { // from class: com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivityStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                    ((AbsDelegateAdapterList) customResponsedMessage.getData()).add(new c(null, h.gZY, true));
                }
            }
        });
    }

    private static void aDr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016468, new CustomMessageTask.CustomRunnable<ag>() { // from class: com.baidu.tieba.frs.frsfeedforums.FrsMoreFeedForumsActivityStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<ag> customMessage) {
                return new CustomResponsedMessage<>(2016468, new a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
