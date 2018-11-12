package com.baidu.tieba.im.groupUpdates;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
/* loaded from: classes3.dex */
public class UpdatesActivityStatic {
    static {
        aHS();
    }

    private static void aHS() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new CustomMessageTask.CustomRunnable<UpdatesActivityConfig>() { // from class: com.baidu.tieba.im.groupUpdates.UpdatesActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<UpdatesActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().getIntent().setFlags(268435456);
                    customMessage.getData().startActivity(UpdatesActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
