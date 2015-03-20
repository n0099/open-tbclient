package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class AccountActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2015006, new l());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
