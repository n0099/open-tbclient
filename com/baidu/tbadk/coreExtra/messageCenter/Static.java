package com.baidu.tbadk.coreExtra.messageCenter;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
/* loaded from: classes.dex */
public class Static {
    static {
        b.aHP();
        CustomMessageTask customMessageTask = new CustomMessageTask(CmdConfigCustom.METHOD_INVOKE_ACCOUNT_CHANGE, new CustomMessageTask.CustomRunnable<AccountData>() { // from class: com.baidu.tbadk.coreExtra.messageCenter.Static.1
            @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
            public CustomResponsedMessage<?> run(CustomMessage<AccountData> customMessage) {
                if (l.isMainThread()) {
                    b.aHP().aHT();
                    return null;
                } else if (TbadkCoreApplication.getInst() != null) {
                    TbadkCoreApplication.getInst().handler.post(new Runnable() { // from class: com.baidu.tbadk.coreExtra.messageCenter.Static.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            b.aHP().aHT();
                        }
                    });
                    return null;
                } else {
                    return null;
                }
            }
        });
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
    }
}
