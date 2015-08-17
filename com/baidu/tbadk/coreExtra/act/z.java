package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
class z implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<l> run(CustomMessage<Activity> customMessage) {
        return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PASS_MANAGER, x.wk());
    }
}
