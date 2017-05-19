package com.baidu.tbadk.j;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.j.r;
/* loaded from: classes.dex */
class s implements CustomMessageTask.CustomRunnable<r.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<r.a> customMessage) {
        if (customMessage == null) {
            return null;
        }
        r.a data = customMessage.getData();
        data.aGi = aa.FK().FM();
        data.aGj = aa.FK().FO();
        data.aGA = aa.FK().FN();
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
    }
}
