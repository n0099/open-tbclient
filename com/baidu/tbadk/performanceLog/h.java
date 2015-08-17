package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.performanceLog.e;
/* loaded from: classes.dex */
class h implements CustomMessageTask.CustomRunnable<e.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<e.a> customMessage) {
        if (customMessage == null) {
            return null;
        }
        e.a data = customMessage.getData();
        data.awM = y.Ee().Eg();
        data.awN = y.Ee().Ei();
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_SAMPLE, data);
    }
}
