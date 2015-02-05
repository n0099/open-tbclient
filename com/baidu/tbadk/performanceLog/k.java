package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class k implements CustomMessageTask.CustomRunnable<m> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<m> customMessage) {
        if (customMessage == null) {
            return null;
        }
        m data = customMessage.getData();
        data.agr = ac.zs().zu();
        data.ags = ac.zs().zv();
        return new CustomResponsedMessage<>(2016100, data);
    }
}
