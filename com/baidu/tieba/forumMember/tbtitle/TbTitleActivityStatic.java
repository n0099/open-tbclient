package com.baidu.tieba.forumMember.tbtitle;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes5.dex */
public class TbTitleActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003006, new CustomMessageTask.CustomRunnable<TbTitleActivityConfig>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivityStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<TbTitleActivityConfig> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(TbTitleActivity.class);
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
