package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class j extends k {
    public static int aIM = 0;
    public static int aIN = 1;
    public static int aIO = 2;
    private static CustomMessageTask aIv = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.j.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aIx = r.FW().FY();
            data.aIy = r.FW().Ga();
            data.aIP = r.FW().FZ();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
        }
    });

    /* loaded from: classes.dex */
    public class a {
        public String aIP;
        public String aIx;
        public int aIy;
    }

    static {
        aIv.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aIv);
    }
}
