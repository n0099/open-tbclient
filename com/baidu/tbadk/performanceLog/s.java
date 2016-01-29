package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.performanceLog.r;
/* loaded from: classes.dex */
class s implements CustomMessageTask.CustomRunnable<r.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<r.a> customMessage) {
        if (customMessage == null) {
            return null;
        }
        r.a data = customMessage.getData();
        data.aAj = aa.FY().Ga();
        data.aAk = aa.FY().Gc();
        data.aAB = aa.FY().Gb();
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
    }
}
