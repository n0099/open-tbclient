package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeOnCreateOnMainThreadMessageConfig;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<InvokeOnCreateOnMainThreadMessageConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<InvokeOnCreateOnMainThreadMessageConfig> run(CustomMessage<InvokeOnCreateOnMainThreadMessageConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            ao.AP().AQ();
        }
        return null;
    }
}
