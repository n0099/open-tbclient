package com.baidu.tieba.im.message;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class RequestSendPVTJMessageStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2012110, new i());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
