package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeOnCreateOnMainThreadMessageConfig;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<InvokeOnCreateOnMainThreadMessageConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<InvokeOnCreateOnMainThreadMessageConfig> run(CustomMessage<InvokeOnCreateOnMainThreadMessageConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            com.baidu.tieba.im.c.V(customMessage.getData().getContext());
        }
        return null;
    }
}
