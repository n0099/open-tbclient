package com.baidu.tieba.ala.quitroomrecommend;

import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.task.TbHttpMessageTask;
import com.baidu.live.y.b;
import com.baidu.tieba.ala.quitroomrecommend.data.AlaQuitRoomRecommendResponseMessage;
/* loaded from: classes10.dex */
public class AlaQuitRoomRecommendInitialize {
    static {
        cnG();
        cnF();
    }

    private static void cnF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2913264, new CustomMessageTask.CustomRunnable<TbPageContext>() { // from class: com.baidu.tieba.ala.quitroomrecommend.AlaQuitRoomRecommendInitialize.1
            @Override // com.baidu.live.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<b> run(CustomMessage<TbPageContext> customMessage) {
                return new CustomResponsedMessage<>(2913264, new com.baidu.tieba.ala.quitroomrecommend.a.a(customMessage.getData()));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    private static void cnG() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(1021226, TbConfig.SERVER_ADDRESS + "ala/live/quitLiveRec");
        tbHttpMessageTask.setIsNeedLogin(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setResponsedClass(AlaQuitRoomRecommendResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }
}
