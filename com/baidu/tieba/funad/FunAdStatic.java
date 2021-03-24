package com.baidu.tieba.funad;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.b.i0.q0.a;
import d.b.i0.r0.b;
import d.b.i0.r0.d;
/* loaded from: classes4.dex */
public class FunAdStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<a.b> {
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<a.b> run(CustomMessage<a.b> customMessage) {
            return new CustomResponsedMessage<>(2921525, new b());
        }
    }

    static {
        d.b.i0.q0.b.f59262a.set(new d());
        a();
    }

    public static void a() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2921525, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
