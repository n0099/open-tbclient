package com.baidu.tieba;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeOnCreateOnMainThreadMessageConfig;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class an implements CustomMessageTask.CustomRunnable<InvokeOnCreateOnMainThreadMessageConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<InvokeOnCreateOnMainThreadMessageConfig> run(CustomMessage<InvokeOnCreateOnMainThreadMessageConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            aj.wk().wn();
        }
        return null;
    }
}
