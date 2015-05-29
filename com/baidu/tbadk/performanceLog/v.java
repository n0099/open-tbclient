package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class v implements CustomMessageTask.CustomRunnable<x> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<x> customMessage) {
        if (customMessage == null) {
            return null;
        }
        x data = customMessage.getData();
        data.apZ = ah.DB().DD();
        data.aqa = ah.DB().DF();
        data.aqv = ah.DB().DE();
        return new CustomResponsedMessage<>(2016103, data);
    }
}
