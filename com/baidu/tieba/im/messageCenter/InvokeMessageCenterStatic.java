package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class InvokeMessageCenterStatic {
    static {
        QR();
        QS();
        QT();
    }

    private static void QR() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008004, new a());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void QS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008005, new b());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void QT() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008018, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
