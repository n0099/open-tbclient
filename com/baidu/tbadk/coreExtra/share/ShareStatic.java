package com.baidu.tbadk.coreExtra.share;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ShareStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001283, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
