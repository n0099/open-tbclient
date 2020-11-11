package com.baidu.tieba.ala;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.b.r;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.view.j;
/* loaded from: classes4.dex */
public class AlaRankListActivityInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(r.class, AlaRankListActivity.class);
        bMa();
        bMb();
    }

    private static void bMa() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913036, new CustomMessageTask.CustomRunnable<com.baidu.live.u.a>() { // from class: com.baidu.tieba.ala.AlaRankListActivityInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.u.c> run(CustomMessage<com.baidu.live.u.a> customMessage) {
                if (customMessage.getData() != null) {
                    com.baidu.live.u.a data = customMessage.getData();
                    return new CustomResponsedMessage<>(2913036, new j(data.context, data.liveType, data.userId, data.userName, data.isHost, data.portrait, data.otherParams, data.aVy, data.bri));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void bMb() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.AlaRankListActivityInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.d.a)) {
                    com.baidu.live.liveroom.d.a aVar = (com.baidu.live.liveroom.d.a) customResponsedMessage.getData();
                    if (aVar.bnv != null && aVar.bnv.context != null) {
                        aVar.a((com.baidu.live.liveroom.d.e) new b((TbPageContext) IScrollableHelper.getBbPageContext(aVar.bnv.context)));
                    }
                }
            }
        });
    }
}
