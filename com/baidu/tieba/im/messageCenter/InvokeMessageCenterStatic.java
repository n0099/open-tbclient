package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class InvokeMessageCenterStatic {
    static {
        a();
        b();
        e();
        d();
        c();
        f();
        g();
        h();
        i();
        j();
    }

    private static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005001, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005002, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005003, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2007001, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008002, new l());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008003, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008004, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void h() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008005, new o());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void i() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008018, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void j() {
        com.baidu.tieba.im.b.e.c();
    }
}
