package com.baidu.tieba.easterEgg;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.task.TbHttpMessageTask;
/* loaded from: classes11.dex */
public class EasterEggStatic {
    static {
        bGW();
        bGX();
    }

    private static void bGW() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_RN_SYNC, TbConfig.SERVER_ADDRESS + TbConfig.GET_RN_SYNC_ADDRESS);
        tbHttpMessageTask.setResponsedClass(RnSyncResponseMessage.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    private static void bGX() {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_SYNC_FINISH) { // from class: com.baidu.tieba.easterEgg.EasterEggStatic.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                TbadkCoreApplication.getInst().startService(new Intent(TbadkCoreApplication.getInst(), EasterEggH5Service.class));
            }
        });
    }
}
