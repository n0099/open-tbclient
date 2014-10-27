package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class InvokeMessageCenterStatic {
    static {
        Ql();
        Qn();
        Qm();
        Qo();
        Qp();
        Qq();
    }

    private static void Ql() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005002, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005003, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qn() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008002, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qo() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008004, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008005, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void Qq() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008018, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
