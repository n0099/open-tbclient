package com.baidu.tbadk.coreExtra.act;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class u implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<l> run(CustomMessage<Activity> customMessage) {
        return new CustomResponsedMessage<>(2001275, s.ut());
    }
}
