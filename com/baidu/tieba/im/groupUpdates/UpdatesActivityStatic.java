package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class UpdatesActivityStatic {
    static {
        Nf();
    }

    private static void Nf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
