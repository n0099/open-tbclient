package com.baidu.tieba.im.model;

import com.baidu.adp.framework.task.CustomMessageTask;
/* loaded from: classes.dex */
public class OfficialBarTipModelStatic {
    static {
        CustomMessageTask customMessageTask = new CustomMessageTask(2003004, new bi());
        customMessageTask.a(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        com.baidu.adp.framework.c.a().a(customMessageTask);
    }
}
