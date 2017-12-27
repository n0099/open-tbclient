package com.baidu.tbadk.k;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class j extends k {
    public static int bya = 0;
    public static int byb = 1;
    public static int byc = 2;
    private static CustomMessageTask bxJ = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.k.j.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.bxL = r.Oa().Oc();
            data.bxM = r.Oa().Oe();
            data.byd = r.Oa().Od();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
        }
    });

    /* loaded from: classes.dex */
    public class a {
        public String bxL;
        public int bxM;
        public String byd;
    }

    static {
        bxJ.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(bxJ);
    }
}
