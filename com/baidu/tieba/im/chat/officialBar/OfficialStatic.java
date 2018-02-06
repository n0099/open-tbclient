package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class OfficialStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2001289, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001289, Integer.valueOf(d.f.icon_im_subscribe));
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001290, new CustomMessageTask.CustomRunnable<Void>() { // from class: com.baidu.tieba.im.chat.officialBar.OfficialStatic.2
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
                return new CustomResponsedMessage<>(2001290, Integer.valueOf(d.f.icon_im_tie));
            }
        });
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
    }
}
