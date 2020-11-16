package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.b.s;
import com.baidu.live.b.t;
import com.baidu.live.b.u;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes4.dex */
public class AlaRedPacketInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(u.class, AlaSnatchRedPacketActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(t.class, AlaRedPktSendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(s.class, AlaRedPacketSnatchResultActivity.class);
        bLx();
    }

    private static void bLx() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913130, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaRedPacketInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.w.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913130, new com.baidu.tieba.ala.charm.f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
