package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes3.dex */
public class LocalManagerStatic {
    static {
        Pa();
        Pb();
    }

    private static void Pa() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_LOCAL_PUSH_DATA, TbConfig.SERVER_ADDRESS + TbConfig.GET_LOCAL_PUSH_THREAD_INFO);
        tbHttpMessageTask.setResponsedClass(LocalPushRespMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void Pb() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(2001371) { // from class: com.baidu.tieba.LocalManagerStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                long j = com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("local_push_expire", 0L);
                if (j <= System.currentTimeMillis()) {
                    if (j != 0) {
                        com.baidu.tbadk.core.sharedPref.b.getInstance().remove("local_push_expire");
                    }
                    if (!StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbSingleton.getInstance().isNewUser()) {
                        d.Pe().Pd();
                    }
                }
            }
        });
    }
}
