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
        CustomMessageTask customMessageTask = new CustomMessageTask(2007001, new d());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void b() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2007002, new g());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void c() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2007003, new j());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void d() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2009001, new k());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void e() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010002, new l());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void f() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010003, new m());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void g() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010004, new n());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void h() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010005, new o());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void i() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2010018, new p());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void j() {
        com.baidu.tieba.im.b.e.c();
    }
}
