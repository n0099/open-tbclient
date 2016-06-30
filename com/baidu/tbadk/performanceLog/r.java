package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r extends t {
    public static int ayg = 0;
    public static int ayh = 1;
    public static int ayi = 2;
    private static CustomMessageTask axP = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new s());

    /* loaded from: classes.dex */
    public class a {
        public String axR;
        public int axS;
        public String ayj;
    }

    static {
        axP.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(axP);
    }
}
