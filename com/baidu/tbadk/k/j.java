package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class j extends k {
    public static int aKf = 0;
    public static int aKg = 1;
    public static int aKh = 2;
    private static CustomMessageTask aJO = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.j.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJQ = r.GA().GC();
            data.aJR = r.GA().GE();
            data.aKi = r.GA().GD();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
        }
    });

    /* loaded from: classes.dex */
    public class a {
        public String aJQ;
        public int aJR;
        public String aKi;
    }

    static {
        aJO.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJO);
    }
}
