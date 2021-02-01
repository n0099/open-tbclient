package com.baidu.tieba.ala.poke;

import android.content.Context;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.d.r;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.v.b;
import com.baidu.live.v.c;
/* loaded from: classes11.dex */
public class AlaPokeInitialize {
    static {
        cor();
        coq();
        bOl();
        bOp();
    }

    private static void coq() {
        TbadkCoreApplication.getInst().RegisterIntent(r.class, AlaPokeDialogActivity.class);
    }

    private static void cor() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913262, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.poke.AlaPokeInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.v.a> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913262, new a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOl() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913265, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.poke.AlaPokeInitialize.2
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<c> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913265, com.baidu.tieba.ala.poke.startanim.c.cow());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bOp() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913266, new CustomMessageTask.CustomRunnable<Context>() { // from class: com.baidu.tieba.ala.poke.AlaPokeInitialize.3
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<b> run(CustomMessage<Context> customMessage) {
                return new CustomResponsedMessage<>(2913266, new com.baidu.tieba.ala.poke.startanim.a());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
