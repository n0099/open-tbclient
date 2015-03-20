package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
/* loaded from: classes.dex */
class g implements CustomMessageTask.CustomRunnable<UpdatesActivityConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<UpdatesActivityConfig> customMessage) {
        if (customMessage != null && customMessage.getData() != null) {
            customMessage.getData().getIntent().setClass(customMessage.getData().getContext(), UpdatesActivity.class);
            customMessage.getData().getIntent().setFlags(268435456);
            customMessage.getData().startActivity();
        }
        return null;
    }
}
