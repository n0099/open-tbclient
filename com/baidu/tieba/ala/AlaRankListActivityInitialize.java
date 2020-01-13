package com.baidu.tieba.ala;

import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.c.n;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.ala.view.f;
/* loaded from: classes2.dex */
public class AlaRankListActivityInitialize {
    static {
        TbadkCoreApplication.getInst().RegisterIntent(n.class, AlaRankListActivity.class);
        aZm();
        aZn();
    }

    private static void aZm() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913036, new CustomMessageTask.CustomRunnable<com.baidu.live.m.a>() { // from class: com.baidu.tieba.ala.AlaRankListActivityInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.m.c> run(CustomMessage<com.baidu.live.m.a> customMessage) {
                if (customMessage.getData() != null) {
                    com.baidu.live.m.a data = customMessage.getData();
                    return new CustomResponsedMessage<>(2913036, new f(data.context, data.liveType, data.userId, data.userName, data.isHost, data.portrait, data.otherParams, data.aeS, data.atd));
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void aZn() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2913040) { // from class: com.baidu.tieba.ala.AlaRankListActivityInitialize.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.live.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.live.liveroom.c.a)) {
                    com.baidu.live.liveroom.c.a aVar = (com.baidu.live.liveroom.c.a) customResponsedMessage.getData();
                    if (aVar.arV != null && aVar.arV.context != null) {
                        aVar.a((com.baidu.live.liveroom.c.e) new b((TbPageContext) IScrollableHelper.getBbPageContext(aVar.arV.context)));
                    }
                }
            }
        });
    }
}
