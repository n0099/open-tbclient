package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
/* loaded from: classes3.dex */
public class OfficialBarTipActivityStatic {
    static {
        aCj();
    }

    private static void aCj() {
        CustomMessageTask customMessageTask = new CustomMessageTask(2008022, new CustomMessageTask.CustomRunnable<OfficialBarTipActivityConfig>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<OfficialBarTipActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(OfficialBarTipActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
