package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes8.dex */
public class TbadkStatic {
    public static String Tag = "tag";

    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2156675, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.coreExtra.messageCenter.TbadkStatic.1
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<a> run(CustomMessage<a> customMessage) {
                return new CustomResponsedMessage<>(2156675, new e());
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
