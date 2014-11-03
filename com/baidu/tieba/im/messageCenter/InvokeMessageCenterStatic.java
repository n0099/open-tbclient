package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class InvokeMessageCenterStatic {
    static {
        Qo();
        Qq();
        Qp();
        Qr();
        Qs();
        Qt();
    }

    private static void Qo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005002, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005003, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008002, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qr() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008004, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qs() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008005, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qt() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008018, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
