package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.c.p;
import com.baidu.live.c.q;
import com.baidu.live.c.r;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.charm.f;
/* loaded from: classes3.dex */
public class AlaRedPacketInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(r.class, AlaSnatchRedPacketActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(q.class, AlaRedPktSendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(p.class, AlaRedPacketSnatchResultActivity.class);
        brJ();
    }

    private static void brJ() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913130, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaRedPacketInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.r.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913130, new f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
