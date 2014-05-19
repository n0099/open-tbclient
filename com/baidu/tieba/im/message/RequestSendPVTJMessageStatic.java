package com.baidu.tieba.im.message;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfig;
/* loaded from: classes.dex */
public class RequestSendPVTJMessageStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfig.SEND_PV_TJ, new e());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
