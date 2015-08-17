package com.baidu.tieba.frs.frsgood;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.FrsGoodActivityConfig;
/* loaded from: classes.dex */
class u implements CustomMessageTask.CustomRunnable<FrsGoodActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<FrsGoodActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().startActivity(FrsGoodActivity.class);
        }
        return null;
    }
}
