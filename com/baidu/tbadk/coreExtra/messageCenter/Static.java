package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import d.a.c.e.p.l;
import d.a.m0.s.d.b;
/* loaded from: classes3.dex */
public class Static {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<AccountData> {

        /* renamed from: com.baidu.tbadk.coreExtra.messageCenter.Static$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0163a implements Runnable {
            public RunnableC0163a(a aVar) {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.g0().h();
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
            if (l.C()) {
                b.g0().h();
                return null;
            } else if (TbadkCoreApplication.getInst() != null) {
                TbadkCoreApplication.getInst().handler.post(new RunnableC0163a(this));
                return null;
            } else {
                return null;
            }
        }
    }

    static {
        b.g0();
        CustomMessageTask customMessageTask = new CustomMessageTask(2005006, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
