package com.baidu.tieba.frs;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
/* loaded from: classes.dex */
class ak implements CustomMessageTask.CustomRunnable<FrsActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<FrsActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), FrsActivity.class);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
