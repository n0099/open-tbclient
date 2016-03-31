package com.baidu.tbadk.performanceLog;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r extends t {
    public static int aBn = 0;
    public static int aBo = 1;
    public static int aBp = 2;
    private static CustomMessageTask aAW = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new s());

    /* loaded from: classes.dex */
    public class a {
        public String aAY;
        public int aAZ;
        public String aBq;
    }

    static {
        aAW.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aAW);
    }
}
