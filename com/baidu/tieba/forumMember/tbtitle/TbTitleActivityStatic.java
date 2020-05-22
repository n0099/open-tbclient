package com.baidu.tieba.forumMember.tbtitle;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
/* loaded from: classes10.dex */
public class TbTitleActivityStatic {
    public static String Tag = "tag";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.START_TBTITLE_ACTIVITY, new CustomMessageTask.CustomRunnable<TbTitleActivityConfig>() { // from class: com.baidu.tieba.forumMember.tbtitle.TbTitleActivityStatic.1
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
