package com.baidu.tieba.frs;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.VideoTopicActivityConfig;
import com.baidu.tieba.frs.worldcup.videotopic.activity.VideoTopicActivity;
/* loaded from: classes3.dex */
public class FRSWorldCupStatic {
    public static void ayW() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003021, new CustomMessageTask.CustomRunnable<VideoTopicActivityConfig>() { // from class: com.baidu.tieba.frs.FRSWorldCupStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<VideoTopicActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(VideoTopicActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }

    static {
        ayW();
    }
}
