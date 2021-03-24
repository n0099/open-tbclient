package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.SimpleVideoPlayActivityConfig;
import com.baidu.tieba.play.SimpleVideoPlayActivity;
import d.b.h0.s.d.e;
/* loaded from: classes3.dex */
public class TbadkStatic {

    /* loaded from: classes3.dex */
    public static class a implements CustomMessageTask.CustomRunnable<d.b.h0.s.d.a> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<d.b.h0.s.d.a> run(CustomMessage<d.b.h0.s.d.a> customMessage) {
            return new CustomResponsedMessage<>(2156675, new e());
        }
    }

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2156675, new a());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        TbadkCoreApplication.getInst().RegisterIntent(SimpleVideoPlayActivityConfig.class, SimpleVideoPlayActivity.class);
    }
}
