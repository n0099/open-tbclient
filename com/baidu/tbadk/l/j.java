package com.baidu.tbadk.l;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
/* loaded from: classes.dex */
public class j extends k {
    public static int aJw = 0;
    public static int aJx = 1;
    public static int aJy = 2;
    private static CustomMessageTask aJf = new CustomMessageTask(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, new CustomMessageTask.CustomRunnable<a>() { // from class: com.baidu.tbadk.l.j.1
        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<a> customMessage) {
            if (customMessage == null) {
                return null;
            }
            a data = customMessage.getData();
            data.aJh = r.Gi().Gk();
            data.aJi = r.Gi().Gm();
            data.aJz = r.Gi().Gl();
            return new CustomResponsedMessage<>(CmdConfigCustom.CMD_PERF_LIVE_SAMPLE, data);
        }
    });

    /* loaded from: classes.dex */
    public class a {
        public String aJh;
        public int aJi;
        public String aJz;
    }

    static {
        aJf.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(aJf);
    }
}
