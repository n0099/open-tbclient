package com.baidu.tieba.VideoCacheClient;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes2.dex */
public class VCacheClientStatic {
    private static CustomMessageListener aVJ = new j(CmdConfigCustom.MAINTAB_ONCREATE_END);

    static {
        Li();
        MessageManager.getInstance().registerListener(aVJ);
    }

    private static void Li() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.CMD_GET_VIDEO_CACHE_CLIENT, new l());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
