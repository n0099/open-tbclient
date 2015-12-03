package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.performanceLog.o;
/* loaded from: classes.dex */
class p implements CustomMessageTask.CustomRunnable<o.a> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<o.a> customMessage) {
        if (customMessage == null) {
            return null;
        }
        o.a data = customMessage.getData();
        data.axO = y.ES().EU();
        data.axP = y.ES().EW();
        data.ayk = y.ES().EV();
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
    }
}
