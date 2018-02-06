package com.baidu.tieba.im.message;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes3.dex */
public class RequestSendPVTJMessageStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012110, new CustomMessageTask.CustomRunnable<String>() { // from class: com.baidu.tieba.im.message.RequestSendPVTJMessageStatic.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
                if (customMessage != null && customMessage.getData() != null) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_KD_MREAD, customMessage.getData());
                }
                return null;
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
