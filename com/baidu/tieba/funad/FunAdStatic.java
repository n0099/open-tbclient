package com.baidu.tieba.funad;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.a.j0.r0.a;
import d.a.j0.r0.b;
import d.a.j0.s0.c;
import d.a.j0.s0.d;
/* loaded from: classes4.dex */
public class FunAdStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<a.c> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<a.c> run(CustomMessage<a.c> customMessage) {
            return new CustomResponsedMessage<>(2921525, new c());
        }
    }

    static {
        b.f59514a.set(new d());
        a();
    }

    public static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921525, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
