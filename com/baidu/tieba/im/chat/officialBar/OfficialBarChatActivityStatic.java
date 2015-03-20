package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class OfficialBarChatActivityStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new y());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
