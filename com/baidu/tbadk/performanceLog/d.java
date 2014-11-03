package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class d implements CustomMessageTask.CustomRunnable<f> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<f> customMessage) {
        if (customMessage == null) {
            return null;
        }
        f data = customMessage.getData();
        data.YJ = v.uP().uR();
        data.YK = v.uP().uS();
        return new CustomResponsedMessage<>(2016100, data);
    }
}
