package com.baidu.tieba.ala;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.d.t;
import com.baidu.live.d.u;
import com.baidu.live.d.v;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
/* loaded from: classes10.dex */
public class AlaRedPacketInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(v.class, AlaSnatchRedPacketActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(u.class, AlaRedPktSendActivity.class);
        TbadkCoreApplication.getInst().RegisterIntent(t.class, AlaRedPacketSnatchResultActivity.class);
        bOH();
    }

    private static void bOH() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913130, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.AlaRedPacketInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.aa.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913130, new com.baidu.tieba.ala.charm.f(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
