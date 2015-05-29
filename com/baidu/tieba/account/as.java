package com.baidu.tieba.account;

import android.app.Activity;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
class as implements CustomMessageTask.CustomRunnable<Activity> {
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<com.baidu.tbadk.core.a.a> run(CustomMessage<Activity> customMessage) {
        return new CustomResponsedMessage<>(2001300, p.Fc());
    }
}
