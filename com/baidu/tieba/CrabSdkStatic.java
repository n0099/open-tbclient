package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.a.k0.i3.a;
/* loaded from: classes4.dex */
public class CrabSdkStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<a.InterfaceC1389a> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<a.InterfaceC1389a> run(CustomMessage<a.InterfaceC1389a> customMessage) {
            return new CustomResponsedMessage<>(2016565, new d.a.k0.c0.a());
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2016565, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
