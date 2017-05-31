package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r extends t {
    public static int aGk = 0;
    public static int aGl = 1;
    public static int aGm = 2;
    private static CustomMessageTask aFT = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new s());

    /* loaded from: classes.dex */
    public class a {
        public String aFV;
        public int aFW;
        public String aGn;
    }

    static {
        aFT.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aFT);
    }
}
