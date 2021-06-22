package com.baidu.tieba.homeExtra;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import d.a.o0.j3.c;
/* loaded from: classes4.dex */
public class HomeExtraStatic {

    /* loaded from: classes4.dex */
    public static class a implements CustomMessageTask.CustomRunnable<c.a> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<c.a> run(CustomMessage<c.a> customMessage) {
            return new CustomResponsedMessage<>(2156671, new d.a.o0.a1.d.a());
        }
    }

    static {
        MessageManager.getInstance().registerTask(new d.a.o0.a1.a());
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001407, Boolean.TRUE));
        CustomMessageTask customMessageTask = new CustomMessageTask(2156671, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
