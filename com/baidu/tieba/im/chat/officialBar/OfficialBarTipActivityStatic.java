package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class OfficialBarTipActivityStatic {
    static {
        Nf();
    }

    private static void Nf() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008022, new ao());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
