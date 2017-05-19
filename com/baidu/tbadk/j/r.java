package com.baidu.tbadk.j;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class r extends t {
    public static int aGx = 0;
    public static int aGy = 1;
    public static int aGz = 2;
    private static CustomMessageTask aGg = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new s());

    /* loaded from: classes.dex */
    public class a {
        public String aGA;
        public String aGi;
        public int aGj;
    }

    static {
        aGg.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aGg);
    }
}
