package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.InvokeUpdateActivityIsOpenConfig;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
/* loaded from: classes.dex */
class o implements CustomMessageTask.CustomRunnable<InvokeUpdateActivityIsOpenConfig> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<Boolean> run(CustomMessage<InvokeUpdateActivityIsOpenConfig> customMessage) {
        if (customMessage == null) {
            return null;
        }
        return new CustomResponsedMessage<>(2010005, Boolean.valueOf(UpdatesActivity.a));
    }
}
