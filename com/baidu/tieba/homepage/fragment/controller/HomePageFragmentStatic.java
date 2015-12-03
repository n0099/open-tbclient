package com.baidu.tieba.homepage.fragment.controller;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class HomePageFragmentStatic {
    static {
        r rVar = new r(CmdConfigCustom.MAINTAB_ADD_FRAGMENT);
        rVar.setPriority(2);
        MessageManager.getInstance().registerListener(rVar);
        IF();
    }

    private static void IF() {
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.DISCOVER_FRIEND_FEED_NEW, new s());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
