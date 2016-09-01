package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r extends t {
    public static int aCd = 0;
    public static int aCe = 1;
    public static int aCf = 2;
    private static CustomMessageTask aBM = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new s());

    /* loaded from: classes.dex */
    public class a {
        public String aBO;
        public int aBP;
        public String aCg;
    }

    static {
        aBM.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aBM);
    }
}
