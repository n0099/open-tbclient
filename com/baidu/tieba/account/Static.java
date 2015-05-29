package com.baidu.tieba.account;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class Static {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001300, new as());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
