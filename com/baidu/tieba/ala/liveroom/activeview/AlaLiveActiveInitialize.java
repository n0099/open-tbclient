package com.baidu.tieba.ala.liveroom.activeview;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbPageContext;
/* loaded from: classes6.dex */
public class AlaLiveActiveInitialize {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913053, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.liveroom.activeview.AlaLiveActiveInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<com.baidu.live.liveroom.a.a> run(CustomMessage<TbPageContext> customMessage) {
                if (customMessage == null || customMessage.getData() == null) {
                    return null;
                }
                return new CustomResponsedMessage<>(2913053, new b(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
