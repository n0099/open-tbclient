package com.baidu.tieba.im.chat.notify;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class ImMessageCenterFragmentStatic {
    static {
        Ky();
    }

    private static void Ky() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008002, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
