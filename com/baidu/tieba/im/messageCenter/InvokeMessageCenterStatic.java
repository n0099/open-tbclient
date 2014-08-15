package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class InvokeMessageCenterStatic {
    static {
        a();
        c();
        b();
        d();
        e();
        f();
    }

    private static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005002, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005003, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008002, new h());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008004, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008005, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008018, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
