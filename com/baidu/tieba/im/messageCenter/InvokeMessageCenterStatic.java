package com.baidu.tieba.im.messageCenter;

import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class InvokeMessageCenterStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2005001, new c());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2005002, new f());
        customMessageTask2.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2008002, new l());
        customMessageTask3.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2005004, new j());
        customMessageTask4.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2007001, new k());
        customMessageTask5.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask5);
        CustomMessageTask customMessageTask6 = new CustomMessageTask(2005003, new i());
        customMessageTask6.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask6);
        CustomMessageTask customMessageTask7 = new CustomMessageTask(2008003, new m());
        customMessageTask7.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask7);
        CustomMessageTask customMessageTask8 = new CustomMessageTask(2008004, new n());
        customMessageTask8.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask8);
        CustomMessageTask customMessageTask9 = new CustomMessageTask(2008005, new o());
        customMessageTask9.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask9);
        com.baidu.tieba.im.b.e.b();
    }
}
